package com.example.booking.dataservices;

import com.example.booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDataService {
    @Autowired
    private CustomerRepository customerRepository;
}
