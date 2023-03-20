package com.ak.backend.Backend.service;

import com.ak.backend.Backend.dto.LoginCredentialRequest;
import com.ak.backend.Backend.dto.UserRequest;
import com.ak.backend.Backend.dto.UserResponse;
import com.ak.backend.Backend.exception.UserAlreadyExistException;

public interface UserService {

    UserResponse loginUser(LoginCredentialRequest userCredential);
    String registerUser(UserRequest userRequest) throws UserAlreadyExistException;

}
