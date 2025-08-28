package com.cts.optional;

import com.cts.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OptionalBasics {

    public static void main(String[] args) throws Throwable {

        Task t = new Task(1, "Learn Java", 5, "Done", List.of("Bac", "Lak"));

//        if(t != null && t.getUsers() !=null){
//            System.out.println(t.getUsers().get(0));
//        }
//        else {
//            System.out.println("No Users");
//        }

//        String users = Optional.ofNullable(t).map(Task::getUsers)
//                .filter(u -> !u.isEmpty())
//                .stream()
//                .flatMap(s -> s.stream())
//                .findFirst().orElse("No Users");
//

        var users = Optional.ofNullable(t).map(Task::getUsers)
                .orElse(List.of());

        if(!users.isEmpty()){
            users.forEach(System.out::println);
        }




        // String users = userList.stream().collect(Collectors.joining(","));


        System.out.println(users);


    }

}
