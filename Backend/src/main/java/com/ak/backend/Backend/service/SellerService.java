package com.ak.backend.Backend.service;

import com.ak.backend.Backend.dto.MenuItemRequest;
import com.ak.backend.Backend.dto.MenuItemResponse;
import com.ak.backend.Backend.dto.SellerRequest;
import com.ak.backend.Backend.exception.MenuItemNotFoundException;
import com.ak.backend.Backend.exception.SellerAlreadyExistException;

public interface SellerService{

    String addRestaurant(SellerRequest sellerReq) throws SellerAlreadyExistException;

    MenuItemResponse addMenuItem(MenuItemRequest menuItemReq);

    MenuItemResponse updateMenuItem(long itemId, MenuItemRequest menuItemReq) throws MenuItemNotFoundException;

    String deleteMenuItem(long itemId) throws MenuItemNotFoundException;

}
