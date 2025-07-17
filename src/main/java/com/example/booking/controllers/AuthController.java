package com.example.booking.controllers;


import com.example.booking.dataservices.CustomerDataService;
import com.example.booking.dataservices.SupplierDataService;
import com.example.booking.dataservices.UserDataService;
import com.example.booking.dtos.AuthRequestDTO;
import com.example.booking.entities.CustomerEntity;
import com.example.booking.entities.SupplierEntity;
import com.example.booking.entities.UserEntity;
import com.example.booking.enums.UserType;
import com.example.booking.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final UserDataService userDataService;

    private final SupplierDataService supplierDataService;

    private final CustomerDataService customerDataService;

    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          UserDataService userDataService, PasswordEncoder passwordEncoder,
                          CustomerDataService customerDataService, SupplierDataService supplierDataService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDataService = userDataService;
        this.passwordEncoder = passwordEncoder;
        this.customerDataService = customerDataService;
        this.supplierDataService = supplierDataService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        String token = jwtUtil.generateToken(request.getEmail());
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody AuthRequestDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserType(userDTO.getUserType());
        user.setCity(userDTO.getCity());
        user.setCountry(userDTO.getCountry());
        userDataService.save(user);
        if(userDTO.getUserType().equals(UserType.CUSTOMER.name())){
            CustomerEntity customer = new CustomerEntity();
            customer.setAmount(0.0);
            customer.setUser(user);
            customer.setCurrency("USD");
            customerDataService.save(customer);
        } else if (userDTO.getUserType().equals(UserType.SUPPLIER.name())) {
            SupplierEntity supplier = new SupplierEntity();
            supplier.setUser(user);
            supplierDataService.save(supplier);
        }
        return ResponseEntity.ok("User registered");
    }
}
