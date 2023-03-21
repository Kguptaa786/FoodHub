package com.ak.backend.Backend.service;

import com.ak.backend.Backend.dto.AuthRequest;
import com.ak.backend.Backend.dto.UserRequest;
import com.ak.backend.Backend.entity.User;
import com.ak.backend.Backend.exception.UserAlreadyExistException;
import com.ak.backend.Backend.repository.UserRepo;
import com.ak.backend.Backend.util.JwtAuthService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    private JwtAuthService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserRepo userRepo;

    @Override
    public String logoutUser() {
        return null;
    }

    @Override
    public String loginUser(AuthRequest authRequest) {
        //login for validation
        Authentication auth=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
        String jwtToken;
        if(auth.isAuthenticated()){
            jwtToken=jwtService.generateToken(authRequest.getEmail());
        }
        else {
            throw new UsernameNotFoundException("Invalid user credential");
        }
        return jwtToken;
    }

    @Override
    public String registerUser(UserRequest userRequest) throws UserAlreadyExistException {
        User userAlreadyExist=userRepo.findByEmail(userRequest.getEmail());
        if(userAlreadyExist!=null){
            LOGGER.error("User is already exist of email {}",userAlreadyExist.getEmail());
            throw new UserAlreadyExistException("User with email "+userRequest.getEmail()+" already exist");
        }
        User user=mapper.map(userRequest,User.class);
        //store hash password

        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepo.save(user);
        LOGGER.info("User registered successfully of email {}",user.getEmail());
        return "User registered successfully";
    }

}
