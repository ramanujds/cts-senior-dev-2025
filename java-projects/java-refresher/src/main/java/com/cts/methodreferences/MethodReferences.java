package com.cts.methodreferences;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Locale;

class Greetings{
    void greet(String name){
        System.out.println("Hello "+name+", welcome to Bangalore");
    }
}

public class MethodReferences {



    public static void main(String[] args) {
        List<String> names = List.of("Karan","Suraj","Javed","Nikhil");
        Greetings greetings = new Greetings();
        names.stream().map(String::toUpperCase).forEach(greetings::greet);

    }

}
