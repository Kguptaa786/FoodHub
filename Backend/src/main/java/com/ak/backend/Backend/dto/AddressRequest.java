package com.ak.backend.Backend.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    @NotBlank(message = "Street cannot be empty")
    private String street;
    @NotNull(message = "House no. cannot be empty")
    private int houseNo;
    @NotBlank(message = "City cannot be empty")
    private String city;
    @NotBlank(message = "District cannot be empty")
    private String district;
    @NotBlank(message = "State cannot be empty")
    private String state;
    @NotBlank(message = "Country cannot be empty")
    private String country;
    private Double latitude;
    private Double longitude;
    @Pattern(regexp = "^\\d{6}$",message = "Postal Code must be of 6 digits")
    private String postalCode;
}
