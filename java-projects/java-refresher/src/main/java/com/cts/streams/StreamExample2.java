package com.cts.streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample2 {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 4, 3, 2, 8, 9, 5, 7, 4, 6);


        var even = nums.stream()
                .distinct()
                .sorted()
                .filter(n -> n % 2 == 0)
//                .map(n -> "square of " + n + " = " + n * n)
//                .skip(3)
                .noneMatch(n->n>6);



        System.out.println(even);


    }

}
