package com.ak.backend.Backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String street;
    @NotBlank
    private int houseNo;
    @NotBlank
    private String city;
    @NotBlank
    private String district;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    @NotBlank
    private int postalCode;

}
