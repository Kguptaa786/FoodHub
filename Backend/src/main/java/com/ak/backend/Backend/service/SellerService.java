package com.ak.backend.Backend.service;

import com.ak.backend.Backend.dto.*;
import com.ak.backend.Backend.exception.MenuItemNotFoundException;
import com.ak.backend.Backend.exception.SellerAlreadyExistException;

public interface SellerService{

    AuthResponse loginSeller(AuthRequest authRequest);

    String addRestaurant(SellerRequest sellerReq) throws SellerAlreadyExistException;

    MenuItemResponse addMenuItem(MenuItemRequest menuItemReq);

    MenuItemResponse updateMenuItem(long itemId, MenuItemRequest menuItemReq) throws MenuItemNotFoundException;

    String deleteMenuItem(long itemId) throws MenuItemNotFoundException;

}
