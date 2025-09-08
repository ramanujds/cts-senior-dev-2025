package com.cts.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    public UserDetailsService getUserDetailsService() {
        UserDetails user1 = User.withUsername("admin")
                .password("{noop}pass1234")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("ramanuj")
                .password("{noop}pass1234")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);

    }

    @Bean
    public SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(
                        request -> request.requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/users/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/public/**").permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .build();

    }

}
