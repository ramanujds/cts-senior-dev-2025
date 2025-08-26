package com.cts.lambdas;


import java.util.concurrent.atomic.AtomicInteger;

interface Printable {

    void print(String str);

    default void scan() {
        System.out.println("Scanner not implemented..");
    }

    static void show() {

    }
}

interface MathOperation {
    int perform(int a, int b);
}

class Calculator {
    int calculate(int a, int b, MathOperation op) {
        return op.perform(a, b);
    }
}


public class LambdaBasics {

    public static void main(String[] args) {
        Printable printable = str -> System.out.println(str + "...");
        printable.print("Hello");
        printable.scan();

        Calculator calc = new Calculator();
        int x = 10, y = 4;
        int sum = calc.calculate(x, y, (a, b) -> a + b);

        int product = calc.calculate(x, y, (a, b) -> a * b);
        AtomicInteger gcd = new AtomicInteger(1);
        calc.calculate(x, y, (a, b) -> {
            int min = a < b ? a : b;
            for (int i = 1; i <= min; i++) {
                if (a % i == 0 && b % i == 0) {
                    gcd.set(i);
                }
            }
            return 0;});

            System.out.println(gcd.get());

        }

    }
