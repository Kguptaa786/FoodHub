package com.ak.backend.Backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String role;
    private String name;
    private String email;
    private String password;
    private String contactNo;
    @OneToOne(fetch =FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId",referencedColumnName = "id")
    private Address address;
    @OneToOne(fetch =FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurantId",referencedColumnName = "id")
    private Restaurant restaurant;

}
