package com.cts.app.api;

import com.cts.app.model.UserEntity;
import com.cts.app.repository.UserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {


    private final UserRepository userRepository;

    public GreetController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/public")
    public String sayHello(){
        return "Hello from Bengaluru";
    }

    @GetMapping("/admin")
    public String sayHelloAdmin(){
        return "Hello from Admin";
    }

    @PostMapping("/users")
    public String sayHelloUser(){
        return "Hello from User";
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String greet(){
        return "Hello all..";
    }

    @GetMapping("/u/{username}")
    @PostAuthorize("returnObject.username == authentication.name or hasRole('ADMIN')")
    public UserEntity getUserDetails(@PathVariable String username){
        return userRepository.findByUsername(username).get();
    }

}
