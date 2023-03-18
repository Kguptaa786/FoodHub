package com.ak.backend.Backend.dto;


import com.ak.backend.Backend.entity.Restaurant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Description cannot be empty")
    @Size(min=10,max=50,message = "Description should be min 10 characters and max 50 characters")
    private String description;
    @NotNull(message = "Price cannot be empty")
    private int price;
    @NotBlank(message = "At least one image is required")
    private List<String> images;
    private String type;
    private Restaurant restaurant;
}
