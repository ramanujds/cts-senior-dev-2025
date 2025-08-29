package com.cts.records;

public class RecordPatternsBasics {

    public static void main(String[] args) {

        Object obj = new Employee("James",25,new Address("Bengaluru","Karnataka"));

        switch (obj){
            case Employee(var name, var age, Address(var city, var state)) -> System.out.println(
                    "Name : "+name+" | City : "+city
            );

            default -> System.out.println("Invalid Details");
        }


    }

}
