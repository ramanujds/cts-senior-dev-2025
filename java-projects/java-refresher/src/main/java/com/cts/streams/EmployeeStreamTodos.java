package com.cts.streams;

import com.cts.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamTodos {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(
                new Employee(106, "Fiona Green", 70000.0, "Marketing", 30, "Female", "Bangalore"),
                new Employee(105, "Edward Wilson", 55000.0, "Human Resources", 25, "Male", "Bangalore"),
                new Employee(101, "Alice Johnson", 75000.0, "Marketing", 32, "Female", "New York"),
                new Employee(102, "Bob Smith", 82000.0, "Engineering", 45, "Male", "Bangalore"),
                new Employee(103, "Charlie Davis", 68000.50, "Sales", 28, "Male", "Chicago"),
                new Employee(104, "Diana Miller", 95000.75, "Engineering", 51, "Female", "Bangalore")
        );


        // Group employees based on dept

        var empDept = employees.stream().collect(
                Collectors.groupingBy(Employee::department)
        );


        // Count employees in each dept

        var empDeptCount = employees.stream().collect(
                Collectors.groupingBy(Employee::department, Collectors.counting())
        );

    //    System.out.println(empDeptCount);


        // All dept names

        var depts = employees.stream().map(Employee::department).collect(Collectors.toSet());
        // System.out.println(depts);

        // Average age for male and female

        var avgAgePerGender = employees.stream().collect(
                Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age))
        );

  //      System.out.println(avgAgePerGender);

        // Dept with max no. of employees

        var maxEmpDept = employees.stream().collect(
                Collectors.groupingBy(Employee::department, Collectors.counting())
        );

        Map.Entry<String,Long> dept = maxEmpDept.entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().intValue())).get();

       // System.out.println(dept.getKey());

        // Employees from Bengaluru, sorted by names


        // Second Highest Paid employee

        var emp = employees.stream().max(Comparator.comparing(Employee::salary)).get();

        var output = employees.stream().filter(e->!e.equals(emp))
                .max(Comparator.comparing(Employee::salary)).get();

        System.out.println(output);




        // Average salary for each dept

        var avgSalaryPerDept = employees.stream().collect(
                Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary))
        );

//        System.out.println(avgSalaryPerDept);

    }
}
