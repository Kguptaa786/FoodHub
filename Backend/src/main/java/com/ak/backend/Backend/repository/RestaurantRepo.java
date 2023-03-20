package com.ak.backend.Backend.repository;

import com.ak.backend.Backend.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {
}
