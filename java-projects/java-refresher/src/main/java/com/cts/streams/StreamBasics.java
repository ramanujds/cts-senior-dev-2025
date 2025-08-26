package com.cts.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {

    public static void main(String[] args) {

        var value = 10;

        var names = List.of("phone", "laptop", "watch", "camera");

        var updatedList = names.stream()
                .filter(e -> e.length() == 6)
                .map(String::toUpperCase)
                .toList();

        System.out.println(updatedList);

    }

}
