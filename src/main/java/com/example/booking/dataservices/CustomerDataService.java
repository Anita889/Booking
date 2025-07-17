package com.example.booking.dataservices;

import com.example.booking.entities.CustomerEntity;
import com.example.booking.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerDataService {
    private final CustomerRepository customerRepository;

    public CustomerDataService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(CustomerEntity customer) {
    }
}
