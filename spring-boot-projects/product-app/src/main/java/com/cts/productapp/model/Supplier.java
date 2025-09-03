package com.cts.productapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Supplier {

    @Id
    private int id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    @JsonBackReference
    Set<Product> products;


}
