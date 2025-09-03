package com.cts.greetwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetAppController {

    @GetMapping("/greet")
    public ModelAndView greet(){
        System.out.println("Going to hello.html");
        return new ModelAndView("hello.html");
    }

}
