package com.ak.backend.Backend.controllers;


import com.ak.backend.Backend.entities.User;
import com.ak.backend.Backend.utils.UserCredential;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {


    @PostMapping("/login")
    public String loginUser(@RequestBody UserCredential user){
        System.out.println(user.getEmail()+" "+user.getPassword());
        return "login user";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        System.out.println(user.getAddress().toString());
        return "register user";
    }
}
