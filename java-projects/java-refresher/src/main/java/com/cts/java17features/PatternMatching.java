package com.cts.java17features;

public class PatternMatching {
    public static void main(String[] args) {

        Object apiError = "...";

        if (apiError instanceof String error){
            // ...
        } else if (apiError instanceof Integer status){
            // ...
        } else if (apiError instanceof Exception e) {
            //..
        }

        // Java 21
        switch (apiError){
            case String msg -> System.out.println(msg);
            case Integer status -> System.out.println(status);
            default -> {}
        }

    }

}
