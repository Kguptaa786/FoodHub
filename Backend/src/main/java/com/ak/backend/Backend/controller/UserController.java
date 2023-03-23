package com.ak.backend.Backend.controller;


import com.ak.backend.Backend.dto.*;
import com.ak.backend.Backend.exception.UserAlreadyExistException;
import com.ak.backend.Backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid AuthRequest authRequest){
        ApiResponse<AuthResponse> apiResponse=new ApiResponse<>
                ("Successfully logged in",true, userService.loginUser(authRequest));
        return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
    }

    @PostMapping("/logout")
    public String logoutUser(){
        return "logout user";
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRequest userRequest) throws UserAlreadyExistException {
        ApiResponse<?> apiResponse=new ApiResponse<>
                ("User is successfully registered",true,userService.registerUser(userRequest));
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

}
