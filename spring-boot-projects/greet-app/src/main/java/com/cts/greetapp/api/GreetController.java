package com.cts.greetapp.api;

import com.cts.greetapp.dto.GreetMessage;
import com.cts.greetapp.service.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    private GreetService greetService;


    public GreetController(GreetService greetService) {
        this.greetService = greetService;
    }

    @GetMapping
    public GreetMessage sayHello(){
        return greetService.getGreetMessage();
    }

}
