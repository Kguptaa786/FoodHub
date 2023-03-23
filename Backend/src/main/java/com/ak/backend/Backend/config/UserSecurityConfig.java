package com.ak.backend.Backend.config;

import com.ak.backend.Backend.JwtUtil.UserJwtFilter;
import com.ak.backend.Backend.entity.User;
import com.ak.backend.Backend.repository.UserRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(1)
public class UserSecurityConfig {

    private static final Logger LOGGER= LogManager.getLogger(UserSecurityConfig.class);

    @Autowired
    private UserJwtFilter userJwtFilter;
    @Autowired
    private UserRepo userRepo;

    @Bean(name = "userDetailsService1")
    public UserDetailsService userDetailsService1(){
        return username -> {
            User user=userRepo.findByEmail(username);
            if(user==null){
                LOGGER.error("User not found with email {}",username);
                throw new UsernameNotFoundException("User not found with email "+username);
            }
            LOGGER.info("User found with email {}",username);
            return user;
        };
    }

    @Bean
    @Primary
    public PasswordEncoder passwordEncoder1(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/user/login","/api/user/register",
                        "/api/seller/add-restaurant","/api/seller/login",
                        "api/home/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(daoAuthenticationProvider1())
                .addFilterBefore(userJwtFilter, UsernamePasswordAuthenticationFilter.class);

//                .logout()
//                .logoutUrl("/")
//                .add;

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider1(){
        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService1());
        authProvider.setPasswordEncoder(passwordEncoder1());
        return authProvider;
    }

    @Bean
    @Primary
    public AuthenticationManager authenticationManager1(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
