package com.ak.backend.Backend.service;

import com.ak.backend.Backend.JwtUtil.JwtService;
import com.ak.backend.Backend.dto.ApiResponse;
import com.ak.backend.Backend.dto.AuthRequest;
import com.ak.backend.Backend.dto.AuthResponse;
import com.ak.backend.Backend.dto.UserRequest;
import com.ak.backend.Backend.entity.User;
import com.ak.backend.Backend.exception.UserAlreadyExistException;
import com.ak.backend.Backend.repository.UserRepo;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER= LogManager.getLogger(UserServiceImpl.class);
    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepo;


    @Override
    public AuthResponse loginUser(AuthRequest authRequest) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
        if(!authentication.isAuthenticated()){
            throw new UsernameNotFoundException("Invalid Credential");
        }
        return new AuthResponse(jwtService.generateToken(authRequest.getEmail()));
    }

    @Override
    public String registerUser(UserRequest userRequest) throws UserAlreadyExistException {
        User userAlreadyExist=userRepo.findByEmail(userRequest.getEmail());
        if(userAlreadyExist!=null){
            LOGGER.error("User is already exist of email {}",userAlreadyExist.getEmail());
            throw new UserAlreadyExistException("User with email "+userRequest.getEmail()+" already exist");
        }
        User user=mapper.map(userRequest,User.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepo.save(user);
        LOGGER.info("User registered successfully of email {}",user.getEmail());
        return "User registered successfully";
    }

}
