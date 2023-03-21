package com.ak.backend.Backend.config;

import com.ak.backend.Backend.entity.User;
import com.ak.backend.Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BuyerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepo.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User not found with email id"+email);
        }
        return new BuyerUserDetails(user);
    }
}
