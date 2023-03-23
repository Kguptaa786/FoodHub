package com.ak.backend.Backend.config;

import com.ak.backend.Backend.JwtUtil.SellerJwtFilter;
import com.ak.backend.Backend.entity.Seller;
import com.ak.backend.Backend.repository.SellerRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Order(2)
public class SellerSecurityConfig {

    private static final Logger LOGGER= LogManager.getLogger(SellerSecurityConfig.class);

    @Autowired
    private SellerJwtFilter sellerJwtFilter;
    @Autowired
    private SellerRepo sellerRepo;

    @Bean(name = "userDetailsService2")
    public UserDetailsService userDetailsService2(){
        return username -> {
            Seller seller=sellerRepo.findByEmail(username);
            if(seller==null){
                LOGGER.error("Seller not found with email {}",username);
                throw new UsernameNotFoundException("User not found with email "+username);
            }
            LOGGER.info("Seller found with email {}",username);
            return seller;
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder2(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
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
                .authenticationProvider(daoAuthenticationProvider2())
                .addFilterBefore(sellerJwtFilter, UsernamePasswordAuthenticationFilter.class);

//                .logout()
//                .logoutUrl("/")
//                .add;

        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider2(){
        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService2());
        authProvider.setPasswordEncoder(passwordEncoder2());
        return authProvider;
    }

    @Bean(name = "authenticationManager2")
    public AuthenticationManager authenticationManager2(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
