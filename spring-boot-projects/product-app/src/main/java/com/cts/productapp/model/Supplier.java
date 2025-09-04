package com.cts.productapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Supplier {

    @Id
    private int id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "supplier")
    @JsonManagedReference
    List<Product> products = new ArrayList<>();


}
