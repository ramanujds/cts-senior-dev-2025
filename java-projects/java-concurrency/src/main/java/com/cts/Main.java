package com.cts;


//class Task implements Runnable{
//    @Override
//    public void run() {
//        System.out.println("Hello from Task : "+Thread.currentThread().getName());
//    }
//}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            System.out.println("From : " + Thread.currentThread().getName());
//            Thread.yield();

            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + (i + 1));
                if (i==2)
                    Thread.yield();
//                try {
//                    Thread.sleep(300);
//                } catch (InterruptedException ex) {
//                }

            }
        };
        Thread t1 = new Thread(task1);

        t1.start();
        //       t1.join();
        System.out.println("Hello from " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            if (i==5){
                Thread.yield();
            }
            System.out.println("m = " + (i + 1));
        }


    }
}