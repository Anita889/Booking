package com.example.booking.dataservices;

import com.example.booking.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SupplierDataService {
    @Autowired
    private SupplierRepository supplierRepository;
}
