package com.cts.streams;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupingFunction {

    public static void main(String[] args) {

        List<String> words = List.of("drive","play","code","fun","dance");

        // Group based of length

        var groupByLength = words.stream().collect(
                Collectors.groupingBy(s->s.length())
        );

       // System.out.println(groupByLength);

        var groupByLengthCounting = words.stream().collect(
                Collectors.groupingBy(s->s.length(), Collectors.counting())
        );

       System.out.println(groupByLengthCounting);

    }

}
