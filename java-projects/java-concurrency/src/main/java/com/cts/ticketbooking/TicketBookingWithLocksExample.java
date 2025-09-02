package com.cts.ticketbooking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TicketBookingWithLocksExample {

    public static void main(String[] args) {

        TicketBooking ticketBooking = new TicketBooking();

        Runnable task = () -> {
            try {
                ticketBooking.bookSeat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();


    }

}
