package com.cts.streams;

import com.cts.model.Task;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectors {

    public static void main(String[] args) {

        List<String> words = List.of("drive","play","code","fun","dance");

        var collection = words.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        String csv = words.stream().collect(Collectors.joining(", "));

       var nums = List.of(1,2,3,4);

       var sum = nums.stream().collect(Collectors.reducing(0,(s,e)->s+e));

        System.out.println(sum);

      // int sum = nums.stream().collect(Collectors.summingInt(n->n));

       var avg = nums.stream().collect(Collectors.averagingInt(n->n));

       var stats = nums.stream().mapToInt(n->n).summaryStatistics();


        Task t1 = new Task(1, "Complete Java Assignment", 5, "Completed", List.of("Harsh", "Karan"));
        Task t2 = new Task(2, "Read about Java Streams", 4, "Pending", List.of("Harsh"));
        Task t3 = new Task(3, "Practice coding questions", 4, "Pending", List.of("Javed"));
        Task t4 = new Task(4, "Watch a movie", 1, "Pending", List.of("Suraj", "Karan"));
        Task t5 = new Task(5, "Go for a walk", 2, "Completed", List.of("Amit"));

        List<Task> tasks = List.of(t1, t2, t3, t4, t5);


//        var importantTasks = tasks.stream()
//                .collect(Collectors.partitioningBy(t->t.getPriority()>3));
//
//
//        importantTasks.forEach((k,v)->{
//            System.out.println(k);
//            v.forEach(System.out::println);
//            System.out.println();
//        });


        var importantTasks = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus,
                        Collectors.mapping(Task::getTitle,Collectors.toList())));

        // System.out.println(importantTasks);




    }

}
