package org.example.service;

import org.example.Dao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public Service service(Dao dao) {
        return new Service(dao);
    }
}
