package com.cts.app.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

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

}
