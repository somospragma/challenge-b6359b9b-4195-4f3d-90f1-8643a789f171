package com.example.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.application.config.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter();
    }
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
           .authorizeRequests().antMatchers("/authenticate").permitAll()
           .anyRequest().authenticated()
           .and().sessionManagement().disable();
        http.addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}