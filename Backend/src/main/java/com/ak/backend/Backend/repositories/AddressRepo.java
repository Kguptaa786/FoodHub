package com.ak.backend.Backend.repositories;

import com.ak.backend.Backend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
