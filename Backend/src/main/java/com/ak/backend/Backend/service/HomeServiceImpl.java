package com.ak.backend.Backend.service;

import com.ak.backend.Backend.dto.LongLatRequest;
import com.ak.backend.Backend.dto.RestaurantResponse;
import com.ak.backend.Backend.entity.Restaurant;
import com.ak.backend.Backend.repository.RestaurantRepo;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class HomeServiceImpl implements HomeService{

    private static final Logger LOGGER= LogManager.getLogger(SellerServiceImpl.class);

    Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public List<RestaurantResponse> getAllRestaurant() {
        List<Restaurant> restaurants=restaurantRepo.findAll();
        List<RestaurantResponse> restaurantRes=new ArrayList<>();
        for(Restaurant restaurant:restaurants){
            restaurantRes.add(mapper.map(restaurant,RestaurantResponse.class));
        }
        LOGGER.info("All restaurant fetches successfully");
        return restaurantRes;
    }

    @Override
    public List<RestaurantResponse> getAllNearbyRestaurant(LongLatRequest longLatReq) {
        return null;
    }
}
