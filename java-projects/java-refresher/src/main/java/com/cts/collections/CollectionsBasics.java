package com.cts.collections;

import com.cts.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsBasics {

    public static void main(String[] args) {

//        String line="Hello sir, how are you? These are simple stream questions. Stream is an interface.";
//        var wordOccur= Arrays.stream(line.split("\\W+")).collect(Collectors.groupingBy(String::toLowerCase, LinkedHashMap::new,Collectors.counting()));
//        System.out.println(wordOccur);

        Set<Employee> set = new TreeSet<>(Comparator.comparing(Employee::salary).reversed());

        List<Employee> employees = Arrays.asList(
                new Employee(106, "Fiona Green", 70000.0, "Marketing", 30, "Female", "Bangalore"),
                new Employee(105, "Edward Wilson", 55000.0, "Human Resources", 25, "Male", "Bangalore"),
                new Employee(101, "Alice Johnson", 75000.0, "Marketing", 32, "Female", "New York"),
                new Employee(102, "Bob Smith", 82000.0, "Engineering", 45, "Male", "Bangalore"),
                new Employee(103, "Charlie Davis", 68000.50, "Sales", 28, "Male", "Chicago"),
                new Employee(104, "Diana Miller", 95000.75, "Engineering", 51, "Female", "Bangalore")
        );

        set.addAll(employees);

        set.forEach(e-> System.out.println(e.name()+" : "+e.salary()));


    }

}
