package com.cts.app.config;

import com.cts.app.security.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AuthConfig {
    private final JwtAuthFilter jwtAuthFilter;

    public AuthConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

//    @Bean
//    public UserDetailsService getUserDetailsService() {
//        UserDetails user1 = User.withUsername("admin")
//                .password("{noop}pass1234")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User.withUsername("ramanuj")
//                .password("{noop}pass1234")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2);
//
//    }

    @Bean
    public SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(
                        request -> request.requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/users/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/**").permitAll()
                )
                .cors(Customizer.withDefaults())
                .csrf(c -> c.disable())
//                .formLogin(Customizer.withDefaults())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .httpBasic(Customizer.withDefaults())
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
