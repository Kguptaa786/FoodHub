package com.ak.backend.Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private List<String> images;
    @OneToOne(mappedBy = "restaurant")
    private Seller seller;
    @OneToMany(mappedBy = "restaurant")
    private List<MenuItem> items;
}
