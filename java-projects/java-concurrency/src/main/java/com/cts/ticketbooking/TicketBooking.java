package com.cts.ticketbooking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBooking {
    private boolean seatBooked;
    Lock lock = new ReentrantLock();
    int total = 5;

    boolean bookSeat() throws InterruptedException {
        if(lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                if (total > 0) {
                    seatBooked = true;
                    System.out.println("Seat Booked by : " + Thread.currentThread().getName());
                    total--;
                    return true;
                } else {
                    System.out.println("Seat already booked");
                }
            } finally {
                lock.unlock();
            }
        }
        else {
            System.out.println("Request Timeout...");
        }

        return false;
    }
}
