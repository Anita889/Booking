package com.example.booking.dataservices;


import com.example.booking.entities.UserEntity;
import com.example.booking.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataService {
    private final UserRepository userRepository;

    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findByUsername(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User with " + email + " not found");
        }
        return user.get();
    }

    public void save(UserEntity user) {
        userRepository.save(user);
    }
}
