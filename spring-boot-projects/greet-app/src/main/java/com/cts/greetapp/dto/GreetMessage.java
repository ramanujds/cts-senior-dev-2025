package com.cts.greetapp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record GreetMessage(
        String message,
        LocalDate date,
        LocalTime time
) {
}
