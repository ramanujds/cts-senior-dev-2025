package com.cts.callableandfuture;

import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<Integer> task = ()->{
            int sum = 0;
            for (int i = 1; i <10 ; i++) {
                sum+=i;
            }
            return sum;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Output : "+future.get());

    }

}
