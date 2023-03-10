package com.ak.backend.Backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class temp {
    @GetMapping("/")
    public String getTemp(){
        return "temp";
    }
}
