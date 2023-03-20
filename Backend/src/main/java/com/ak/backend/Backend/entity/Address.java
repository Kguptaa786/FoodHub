package com.ak.backend.Backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String street;

    private int houseNo;

    private String city;

    private String district;

    private String state;

    private String country;

    private String postalCode;

    private Double latitude;

    private Double longitude;

    @OneToOne(mappedBy = "address")
    private User user;

    @OneToOne(mappedBy = "address")
    private Seller seller;
}
