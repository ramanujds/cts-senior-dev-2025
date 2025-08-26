package com.cts.streams;

import com.cts.model.Task;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTodos {

    public static void main(String[] args) {

        Task t1 = new Task(1, "Complete Java Assignment", 5, "Completed", List.of("Harsh", "Karan"));
        Task t2 = new Task(2, "Read about Java Streams", 4, "Pending", List.of("Harsh"));
        Task t3 = new Task(3, "Practice coding questions", 4, "Pending", List.of("Javed"));
        Task t4 = new Task(4, "Watch a movie", 1, "Pending", List.of("Suraj", "Karan"));
        Task t5 = new Task(5, "Go for a walk", 2, "Completed", List.of("Amit"));

        List<Task> tasks = List.of(t1, t2, t3, t4, t5);


        // Find the task with max priority
        var task = tasks.stream().max((x, y) -> x.getPriority() - y.getPriority()).get();

        System.out.println(task);

        // Get a List containing only titles

        var list = tasks.stream().map(t -> t.getTitle()).toList();

//        System.out.println(list);

        // Find all the tasks with priority > 3

        var filteredTasks = tasks.stream().filter(t -> t.getPriority() >= 3).toList();

//        System.out.println(filteredTasks);

        // Sort tasks based on priority descending and title ascending

//        var sortedTask = tasks.stream().sorted(
//                (a,b)->{
//                    int diff = b.getPriority()-a.getPriority();
//                    return diff != 0?diff:a.getTitle().compareTo(b.getTitle());
//                }
//        ).toList();

        var sortedTask = tasks.stream().
                sorted(Comparator.comparing(Task::getPriority).reversed()
                        .thenComparing(t -> t.getTitle()))
                .toList();

//        System.out.println("After sorting");
//        sortedTask.forEach(System.out::println);

        // Update all the tasks from Pending to Completed.

        var updatedTasks = tasks.stream().peek(t -> t.setStatus("Completed")).toList();

//        System.out.println("After completing");
//
//        updatedTasks.forEach(System.out::println);

        var users = tasks.stream().flatMap(t -> t.getUsers().stream())
                .distinct()
                .toList();

//        users.forEach(System.out::println);

        // Group by priority

        var groupByPriority = tasks.stream()
                .collect(Collectors.groupingBy(t->t.getPriority()));


        groupByPriority.forEach((k,v)-> {
            System.out.println("Priority : "+k);
            v.forEach(t-> System.out.println(t.getTitle()));
            System.out.println();
        });



    }

}
