package com.cts.java17features;

public class Java17Basics {

    public static void main(String[] args) {
        Task task = new Task(1,"Learn Spring Boot","Pending",5);
        Task task1 = new Task();
        String json= """
        {
            "id": "%d",
            "title": "%s",
            "status": "%s"
        }""".formatted(task.id(), task.title(), task.status());

        System.out.println(json);

        String msg = switch (task.status()) {
            case "Completed","Done" -> "Well Done";
            case "Pending","In Progress" -> "Complete the pending work";
            default -> "Unknown Status";
        };
        System.out.println(msg);




    }

}
