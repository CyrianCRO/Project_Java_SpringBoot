package com.groupe6.atelier3.auth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.groupe6.atelier3.lib.mappers.UserMapper;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public UserMapper userMapper( ) {
    	return new UserMapper();
    }
}
