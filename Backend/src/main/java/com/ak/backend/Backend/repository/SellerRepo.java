package com.ak.backend.Backend.repository;

import com.ak.backend.Backend.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller,Long> {
    Seller findByEmail(String email);
}