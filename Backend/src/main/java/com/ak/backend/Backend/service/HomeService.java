package com.ak.backend.Backend.service;

import com.ak.backend.Backend.dto.LongLatRequest;
import com.ak.backend.Backend.dto.RestaurantResponse;

import java.util.List;

public interface HomeService {
    List<RestaurantResponse> getAllRestaurant();
    List<RestaurantResponse> getAllNearbyRestaurant(LongLatRequest longLatReq);
}
