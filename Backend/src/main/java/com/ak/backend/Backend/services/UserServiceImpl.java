//package com.ak.backend.Backend.services;
//
//import com.ak.backend.Backend.entities.User;
//import com.ak.backend.Backend.repositories.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class UserServiceImpl implements UserService{
//    @Autowired
//    private UserRepo userRepo;
//
//    @Override
//    public String registerUser(User user) {
//        userRepo.save(user);
//        return "user added";
//    }
//}
