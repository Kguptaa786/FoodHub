package com.ak.backend.Backend.service;

import com.ak.backend.Backend.dto.AuthRequest;
import com.ak.backend.Backend.dto.AuthResponse;
import com.ak.backend.Backend.dto.UserRequest;
import com.ak.backend.Backend.exception.UserAlreadyExistException;

public interface UserService {

    AuthResponse loginUser(AuthRequest userCredential);
    String registerUser(UserRequest userRequest) throws UserAlreadyExistException;

}
