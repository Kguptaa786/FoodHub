package com.ak.backend.Backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/home")
public class HomeController {

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllRestaurant(@RequestParam(defaultValue = "") String addressReq){
        return null;
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantMenuItems(@RequestParam long restaurantId){
        return null;
    }

}
