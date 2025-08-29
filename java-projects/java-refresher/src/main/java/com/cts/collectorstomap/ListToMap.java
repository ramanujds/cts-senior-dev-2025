package com.cts.collectorstomap;

import com.cts.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(106, "Fiona Green", 70000.0, "Marketing", 30, "Female", "Bangalore"),
                new Employee(105, "Edward Wilson", 55000.0, "Human Resources", 25, "Male", "Bangalore"),
                new Employee(101, "Alice Johnson", 75000.0, "Marketing", 32, "Female", "New York"),
                new Employee(102, "Bob Smith", 82000.0, "Engineering", 45, "Male", "Bangalore"),
                new Employee(103, "Charlie Davis", 68000.50, "Sales", 28, "Male", "Chicago"),
                new Employee(104, "Diana Miller", 95000.75, "Engineering", 51, "Female", "Bangalore"),
                new Employee(104, "David Warner", 98000.75, "Engineering", 34, "Male", "Bangalore")
        );

    //    employees.stream().filter(e-> e != null).forEach(e->System.out.println(e.name()));

        Map<Integer,Employee> employeesMap = employees.stream()
                .collect(Collectors.toMap(Employee::id, Function.identity(),
                        (existing,replacement) -> replacement,
                        LinkedHashMap::new));



        employeesMap.forEach((k,v)-> System.out.println(v));


    }
}
