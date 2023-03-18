package com.ak.backend.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponse {
    private long id;
    private String name;
    private List<String> images;
    //we add the needed response
}
