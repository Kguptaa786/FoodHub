package com.ak.backend.Backend.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "Name should not be blank")
    private String name;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email should not be blank")
    private String email;

    @NotBlank(message = "Password should not be empty")
    @Size(min = 8,max = 16,message = "Password length must be between 8 and 16")
    private String password;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String contactNo;

    @Valid
    private AddressRequest address;
}
