package com.example.booking.dataservices;


import com.example.booking.entities.UserEntity;
import com.example.booking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity findByUsername(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User with " + email + " not found");
        }
        return user.get();
    }
}
