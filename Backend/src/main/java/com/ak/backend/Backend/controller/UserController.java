package com.ak.backend.Backend.controller;


import com.ak.backend.Backend.dto.ApiResponse;
import com.ak.backend.Backend.dto.LoginCredentialRequest;
import com.ak.backend.Backend.dto.UserRequest;
import com.ak.backend.Backend.dto.UserResponse;
import com.ak.backend.Backend.exception.UserAlreadyExistException;
import com.ak.backend.Backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginCredentialRequest userCredential){
        ApiResponse<UserResponse> apiResponse=new ApiResponse<>
                ("Successfully logged in",true, userService.loginUser(userCredential));
        return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRequest userRequest) throws UserAlreadyExistException {
        ApiResponse<String> apiResponse=new ApiResponse<>(userService.registerUser(userRequest),true);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

}
