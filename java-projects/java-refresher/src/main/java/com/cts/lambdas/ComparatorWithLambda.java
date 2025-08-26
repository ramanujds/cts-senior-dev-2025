package com.cts.lambdas;

import java.util.ArrayList;
import java.util.List;

record Task(int id, String name, int priority){}

public class ComparatorWithLambda {

    public static void main(String[] args) {

        List<Task> taskList = new ArrayList<>();


        taskList.add(new Task(1,"Use Git",5));
        taskList.add(new Task(2,"Learn Java",4));
        taskList.add(new Task(3,"Implement Lambda",2));
        taskList.add(new Task(4,"Use Method Reference",3));

        taskList.sort((t1,t2)->t1.name().compareTo(t2.name()));

        taskList.forEach(t-> System.out.println(t));


    }

}
