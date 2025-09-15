package com.cts.portfolioservice.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
public class AuthInterceptor implements RequestInterceptor {
    public void apply(RequestTemplate requestTemplate) {
        log.info("Feign Interceptor called..");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Authentication: {}", authentication);
        if (authentication != null && authentication.isAuthenticated()) {
            String token = authentication.getCredentials().toString();
            log.info("Token: {}", token);
            requestTemplate.header("Authorization", "Bearer " + token);
        }
    }
}
