package com.cts.ticketbooking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TicketBookingWithLocksAndExecutorsExample {

    public static void main(String[] args) {

        TicketBooking ticketBooking = new TicketBooking();

        Runnable task = () -> {
            try {
                ticketBooking.bookSeat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };


        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(task);
        }


    }

}
