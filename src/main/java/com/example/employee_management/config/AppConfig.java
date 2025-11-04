package com.example.employee_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SimplePasswordEncoder passwordEncoder() {
        return new SimplePasswordEncoder();
    }
}
