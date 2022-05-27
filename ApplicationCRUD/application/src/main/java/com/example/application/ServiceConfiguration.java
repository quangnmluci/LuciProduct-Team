package com.example.application;

import org.example.dao.DaoConfiguration;
import org.example.service.ServiceConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.example.dao", "org.example.controller"})
@EnableJpaRepositories("org.example.dao")
@EntityScan("org.example.entity")
@Import({ServiceConfig.class, DaoConfiguration.class})
public class ServiceConfiguration {

}
