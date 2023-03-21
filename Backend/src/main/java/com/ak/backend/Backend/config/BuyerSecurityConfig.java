package com.ak.backend.Backend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(1)
public class BuyerSecurityConfig {

    @Bean
    public UserDetailsService buyerUserDetailsService(){
        return new BuyerUserDetailsService();
    }

    @Bean
    public SecurityFilterChain buyerSecurityFilterChain(HttpSecurity http) throws Exception {
        String API = "/api/user";
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(API +"/login", API +"/register").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(API +"/hello")
                .authenticated()
                .and().formLogin().and()
                .build();
    }

    @Bean
    public DaoAuthenticationProvider buyerDaoAuthenticationProvider(){
        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(buyerUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager buyerAuthenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
