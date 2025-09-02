package com.cts.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadBasics {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = ()->{
            System.out.println("Running in Virtual Thread: "+Thread.currentThread());
        };

//        Thread t1 = Thread.ofVirtual().start(task);
//        t1.join();

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);

        executor.awaitTermination(1, TimeUnit.SECONDS);



    }

}
