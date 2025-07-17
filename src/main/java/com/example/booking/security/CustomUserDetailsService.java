package com.example.booking.security;

import com.example.booking.dataservices.UserDataService;
import com.example.booking.entities.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDataService userDataService;

    public CustomUserDetailsService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserEntity user = userDataService.findByUsername(email);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getUserType())
        ));
    }
}

