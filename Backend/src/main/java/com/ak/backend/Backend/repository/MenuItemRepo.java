package com.ak.backend.Backend.repository;

import com.ak.backend.Backend.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepo extends JpaRepository<MenuItem,Long> {
    MenuItem findById(long id);
    List<MenuItem> findByRestaurantId(long restaurantId);
}
