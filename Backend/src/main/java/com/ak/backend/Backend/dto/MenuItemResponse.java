package com.ak.backend.Backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemResponse {
    private long id;
    private String name;
    private String description;
    private String price;
    private String type;
}
