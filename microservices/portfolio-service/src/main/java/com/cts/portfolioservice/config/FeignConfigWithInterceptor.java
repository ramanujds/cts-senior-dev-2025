package com.cts.portfolioservice.config;

import com.cts.portfolioservice.client.AuthInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigWithInterceptor {

    @Bean
    public RequestInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

}
