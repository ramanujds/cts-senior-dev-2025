package com.cts;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateManipulation {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        LocalTime time = LocalTime.now();

        LocalDate date = LocalDate.parse("05/03/1992",
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

//        var difference = ChronoUnit.DAYS.between(date,today);

//        System.out.println(difference);

        System.out.println(date.isLeapYear());

        System.out.println(date);

        System.out.println(today);

        System.out.println(time);

        Duration duration = Duration.between(date.atStartOfDay(),today.atStartOfDay());

        System.out.println(duration.toDays());

        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(utcTime);

        ZonedDateTime indTime = ZonedDateTime.now();
        System.out.println(indTime);

        Period period = Period.between(date,today);

        System.out.println(period.getYears()+"years : "+period.getMonths()+" months : "+period.getDays()+" days..");


    }

}
