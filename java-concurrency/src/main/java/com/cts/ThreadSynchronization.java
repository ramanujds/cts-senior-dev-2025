package com.cts;

import java.util.Vector;

class Counter{

    private int c = 0;
    void inc(){
        synchronized (this) {
            c++;
        }
    }
    synchronized int get(){
        return c;
    }
}

public class ThreadSynchronization {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = ()-> {
            for (int i = 0; i < 1000; i++) {
                counter.inc();
            }
        };

        Thread t1=new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final value of counter : "+counter.get());

    }

}
