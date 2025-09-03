package com.cts.greetapp.service;

import com.cts.greetapp.dto.GreetMessage;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service("greetService1")
@Primary
public class GreetService {


    public GreetService() {
        System.out.println("Bean Created");
    }

    public GreetMessage getGreetMessage() {
        var time = LocalTime.now();
        String message;
        if (time.isBefore(LocalTime.NOON)) {
            message = "Good Morning";
        } else message = "Good Afternoon";

        return new GreetMessage(message, LocalDate.now(),time);

    }

}
