package com.cts.streams;

import com.cts.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record DeptGenderGroup(String dept, String gender){ }

public class GroupByMultiFields {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(106, "Fiona Green", 70000.0, "Marketing", 30, "Female", "Bangalore"),
                new Employee(105, "Edward Wilson", 55000.0, "Human Resources", 25, "Male", "Bangalore"),
                new Employee(101, "Alice Johnson", 75000.0, "Marketing", 32, "Female", "New York"),
                new Employee(102, "Bob Smith", 82000.0, "Engineering", 45, "Male", "Bangalore"),
                new Employee(103, "Charlie Davis", 68000.50, "Sales", 28, "Male", "Chicago"),
                new Employee(104, "Diana Miller", 95000.75, "Engineering", 51, "Female", "Bangalore"),
                new Employee(107, "David Warner", 98000.75, "Engineering", 34, "Male", "Bangalore")
        );


        var output = employees.stream()
                        .collect(Collectors.groupingBy(e->new DeptGenderGroup(e.department(),e.gender())));

        output.forEach((k,v)-> System.out.println(k+"\n"+v));


    }

}
