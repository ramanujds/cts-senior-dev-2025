package com.cts.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Task {

    private int id;
    private String title;
    private int priority;
    private String status;
    private List<String> users;


}


