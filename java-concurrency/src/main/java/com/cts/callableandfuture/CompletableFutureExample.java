package com.cts.callableandfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Callable<Integer> task = ()->{
//            int sum = 0;
//            for (int i = 1; i <10 ; i++) {
//                sum+=i;
//            }
//            return sum;
//        };

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 1; i < 10; i++) {
                sum += i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            return sum;
        });

        CompletableFuture<String> getValue = future.thenCompose(sum->CompletableFuture.supplyAsync(()->"Sum ="+sum));

        future.thenApplyAsync(x->x+100).thenAccept(output-> System.out.println(output));

        System.out.println("output : "+future.get());

        System.out.println("Done");

    }

}
