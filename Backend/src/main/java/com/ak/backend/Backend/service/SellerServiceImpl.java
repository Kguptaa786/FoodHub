package com.ak.backend.Backend.service;


import com.ak.backend.Backend.dto.*;
import com.ak.backend.Backend.entity.MenuItem;
import com.ak.backend.Backend.entity.Seller;
import com.ak.backend.Backend.exception.MenuItemNotFoundException;
import com.ak.backend.Backend.exception.SellerAlreadyExistException;
import com.ak.backend.Backend.repository.MenuItemRepo;
import com.ak.backend.Backend.repository.SellerRepo;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerServiceImpl implements SellerService{

    private static final Logger LOGGER= LogManager.getLogger(SellerServiceImpl.class);

    Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @Autowired
    private SellerRepo sellerRepo;

    @Autowired
    private MenuItemRepo menuItemRepo;

    @Override
    public AuthResponse loginSeller(AuthRequest authRequest) {
//        Authentication authentication=authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
//        if(!authentication.isAuthenticated()){
//            throw new UsernameNotFoundException("Invalid Credential");
//        }
//        return new AuthResponse(jwtService.generateToken(authRequest.getEmail()));
        return null;
    }

    @Override
    public String addRestaurant(SellerRequest sellerReq) throws SellerAlreadyExistException {
        Seller sellerAlreadyExist=sellerRepo.findByEmail(sellerReq.getEmail());
        if(sellerAlreadyExist!=null){
            LOGGER.error("Seller is already exist of email {}",sellerAlreadyExist.getEmail());
            throw new SellerAlreadyExistException("User with email "+sellerReq.getEmail()+" already exist");
        }
        Seller seller=mapper.map(sellerReq,Seller.class);
        seller.setPassword(sellerReq.getPassword());
        sellerRepo.save(seller);
        LOGGER.info("Seller registered successfully of email {} and restaurant {}",
                seller.getEmail(),seller.getRestaurant().getName());
        return "Seller and restaurant registered successfully";
    }

    @Override
    public MenuItemResponse addMenuItem(MenuItemRequest menuItemReq) {
        MenuItem menuItem=mapper.map(menuItemReq,MenuItem.class);
        menuItemRepo.save(menuItem);
        LOGGER.info("Menu item added successfully of id {}",menuItem);
        return mapper.map(menuItemReq, MenuItemResponse.class);
    }

    @Override
    public MenuItemResponse updateMenuItem(long itemId, MenuItemRequest menuItemReq) throws MenuItemNotFoundException {
        MenuItem menuItem=menuItemRepo.findById(itemId);
        if(menuItem==null){
            LOGGER.error("Menu Item not found with id {}",itemId);
            throw new MenuItemNotFoundException("Menu Item not found with id ",itemId);
        }
        MenuItem updatedMenuItem=mapper.map(menuItemReq, MenuItem.class);
        menuItemRepo.save(updatedMenuItem);
        LOGGER.info("Menu Item is updated successfully of id {}",itemId);
        return mapper.map(menuItemReq,MenuItemResponse.class);
    }

    @Override
    public String deleteMenuItem(long itemId) throws MenuItemNotFoundException {
        MenuItem menuItem=menuItemRepo.findById(itemId);
        if(menuItem==null){
            LOGGER.error("Menu Item not found with id {}",itemId);
            throw new MenuItemNotFoundException("MenuItem not found with id {}",itemId);
        }
        menuItemRepo.deleteById(itemId);
        LOGGER.info("Menu Item is deleted successfully of id {}",itemId);
        return "Menu Item with "+itemId+" is successfully deleted";
    }
}
