package com.ak.backend.Backend.dto;

import com.ak.backend.Backend.entity.Seller;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "At least one image required")
    private List<String> images;
}
