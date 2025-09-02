package com.cts;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {
    AtomicInteger x = new AtomicInteger(0);

    void runThreads() throws InterruptedException{
        Runnable r1 = () -> {
            for (int i=0; i<1000; i++) {
                Thread.currentThread().getName();
                if (x.intValue()>0) {

                }
                x.getAndIncrement();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println(x);
    }
    public static void main(String[] args) throws InterruptedException {

        AtomicOperations obj = new AtomicOperations();
        obj.runThreads();




    }

}
