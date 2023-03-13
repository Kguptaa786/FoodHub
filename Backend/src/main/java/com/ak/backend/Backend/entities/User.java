package com.ak.backend.Backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name should not be blank")
    private String name;

    @Email
    @NotBlank(message = "Email should not be blank")
    private String email;

    @NotBlank(message = "Password should not be empty")
    @Min(value = 8,message = "Password length should be more than equal to 8 characters but less than or equal to 16 characters")
    @Max(value = 16,message = "Password length should be more than equal to 8 characters but less than or equal to 16 characters")
    private String password;

    @NotBlank(message = "Contact should not be empty")
    @Max(value = 10)
    @Min(value = 10)
    private int contactNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId",referencedColumnName = "id")
    private Address address;

}
