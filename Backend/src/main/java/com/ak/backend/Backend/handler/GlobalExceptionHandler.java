package com.ak.backend.Backend.handler;

import com.ak.backend.Backend.exception.SellerAlreadyExistException;
import com.ak.backend.Backend.exception.UserAlreadyExistException;
import com.ak.backend.Backend.dto.ApiResponse;
import com.ak.backend.Backend.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER= LogManager.getLogger(UserServiceImpl.class);
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInvalidUserDataException(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        ApiResponse<?> apiResponse=new ApiResponse<>("All field are mandatory",false,errorMap);
        LOGGER.error("Field are missing {}",errorMap);
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> handleUserAlreadyExistException(UserAlreadyExistException e){
        ApiResponse<?> apiResponse=new ApiResponse<>(e.getMessage(),false);
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SellerAlreadyExistException.class)
    public ResponseEntity<?> handleSellerAlreadyExistException(SellerAlreadyExistException e){
        ApiResponse<?> apiResponse=new ApiResponse<>(e.getMessage(),false);
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}
