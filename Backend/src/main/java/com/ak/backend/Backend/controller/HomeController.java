package com.ak.backend.Backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<?> getAllRestaurant(@RequestParam(defaultValue = "") String addressReq){
        return null;
    }

    @GetMapping("/:restaurantId")
    public ResponseEntity<?> getRestaurantMenuItems(){
        return null;
    }

}
