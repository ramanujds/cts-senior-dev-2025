package com.cts.greetapp.config;

import com.cts.greetapp.service.GreetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


    @Bean
    public GreetService getGreetService(){
        return new GreetService();
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    

}
