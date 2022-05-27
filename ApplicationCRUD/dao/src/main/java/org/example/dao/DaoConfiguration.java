package org.example.dao;

import org.example.Dao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {
    @Bean
    public Dao dao(UserRepository userRepository){
        return new DaoImp(userRepository);
    }
}
