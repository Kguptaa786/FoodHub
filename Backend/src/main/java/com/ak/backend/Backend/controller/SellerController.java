package com.ak.backend.Backend.controller;


import com.ak.backend.Backend.dto.*;
import com.ak.backend.Backend.exception.MenuItemNotFoundException;
import com.ak.backend.Backend.exception.SellerAlreadyExistException;
import com.ak.backend.Backend.service.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired(required = false)
    private SellerService sellerService;

    @PostMapping("/restaurant")
    public ResponseEntity<?> addRestaurant(@RequestBody @Valid SellerRequest sellerReq) throws SellerAlreadyExistException {
        ApiResponse<?> apiResponse=new ApiResponse<>(sellerService.addRestaurant(sellerReq),true );
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/menu-item")
    public ResponseEntity<?> addMenuItem(@RequestBody MenuItemRequest menuItemReq){
        ApiResponse<MenuItemResponse> apiResponse=new ApiResponse<>
                ("Menu item is added successfully",true,sellerService.addMenuItem(menuItemReq));
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @PutMapping("/menu-item/{itemId}")
    public ResponseEntity<?> updateMenuItem(@PathVariable long itemId,@RequestBody MenuItemRequest menuItemReq) throws MenuItemNotFoundException {
        ApiResponse<MenuItemResponse> apiResponse=new ApiResponse<>
                ("Menu item is updated successfully",true,sellerService.updateMenuItem(itemId,menuItemReq));
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @DeleteMapping("/menu-item/:itemId")
    public ResponseEntity<?> deleteMenuItem(@PathVariable long itemId) throws MenuItemNotFoundException {
        ApiResponse<?> apiResponse=new ApiResponse<>
                (sellerService.deleteMenuItem(itemId), true);
        return new ResponseEntity<>(apiResponse,HttpStatus.ACCEPTED);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders(){
        return null;
    }

}
