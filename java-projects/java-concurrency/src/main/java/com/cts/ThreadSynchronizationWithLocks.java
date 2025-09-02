package com.cts;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FlexibleCounter{
    Lock lock = new ReentrantLock();
    private int c = 0;
    void inc(){
        lock.lock();
        try{
            c++;
        }
        finally {
            lock.unlock();
        }
    }
    synchronized int get(){
        return c;
    }
}

public class ThreadSynchronizationWithLocks {

    public static void main(String[] args) throws InterruptedException {
        FlexibleCounter counter = new FlexibleCounter();
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
