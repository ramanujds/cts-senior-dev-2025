package com.cts.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamMemoryLeakExample {

    public static void main(String[] args) {

        List<Integer> nums = Stream.iterate(1,n->n+1).limit(1000).toList();

       Stream<Integer> stream = nums.stream().filter(n->n%2==0);

       //...
        //
        // Many other stuffs..
        //
        //
        // ..

        List output = stream.toList();

        System.out.println(output);



    }

}
