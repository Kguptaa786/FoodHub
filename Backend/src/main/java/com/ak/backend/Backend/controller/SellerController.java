package com.ak.backend.Backend.controller;


import com.ak.backend.Backend.dto.MenuItemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @PostMapping("/restaurant")
    public ResponseEntity<?> addRestaurant(){
        return null;
    }

    @PostMapping("/menu-item")
    public ResponseEntity<?> addMenuItem(@RequestBody MenuItemRequest menuItemReq){
        return null;
    }

    @PutMapping("/menu-item/{itemId}")
    public ResponseEntity<?> updateMenuItem(@PathVariable long itemId,@RequestBody MenuItemRequest menuItemReq){
        return null;
    }

    @DeleteMapping("/menu-item/:itemId")
    public ResponseEntity<?> deleteMenuItem(@PathVariable long itemId){
        return null;
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders(){
        return null;
    }

}
