package com.cts.executerservices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        Runnable task = ()-> {
            System.out.println("Running task by : "+Thread.currentThread().getName());
//            try {
//                Thread.sleep(100);
//            }
//            catch (InterruptedException ex){}
        };

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 50; i++) {
            executor.submit(task);
        }


    }

}
