package com.ak.backend.Backend.repository;

import com.ak.backend.Backend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
