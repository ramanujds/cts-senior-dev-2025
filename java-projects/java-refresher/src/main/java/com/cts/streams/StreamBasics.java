package com.cts.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamBasics {

    public static void main(String[] args) {

        List<String> names= List.of("phone","laptop","watch","camera");

        names.stream()
                .filter(e->e.length()==6)
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }

}
