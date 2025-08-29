package com.cts.java17features;

import java.io.Serializable;

public record Task(int id, String title, String status, int priority) implements Comparable<Task> {

    public int compareTo(Task t){
        return t.id-id;
    }

    public Task(){
        this(0,"","",0);
    }


}