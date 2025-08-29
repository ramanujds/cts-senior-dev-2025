package com.cts.parallelstreams;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamsBasics {


    public static void main(String[] args) {

        List<Integer> nums = IntStream.rangeClosed(1,100000)
                            .boxed().toList();
        nums.getLast();


        // Sequential
        var start = System.currentTimeMillis();

        var sum = nums.stream().mapToLong(n->n*2)
                .sum();

        var end = System.currentTimeMillis();
        var diff = end-start;
        System.out.println("Sequential : ");
        System.out.println("Sum = "+sum);
        System.out.println("Time taken : "+diff);

        // Parallel
        start = System.currentTimeMillis();

        sum = nums.parallelStream().mapToLong(n->n*2)
                .sum();

        end = System.currentTimeMillis();
        diff = end-start;
        System.out.println("Parallel : ");
        System.out.println("Sum = "+sum);
        System.out.println("Time taken : "+diff);




    }

}
