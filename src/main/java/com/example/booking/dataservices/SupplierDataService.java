package com.example.booking.dataservices;

import com.example.booking.entities.SupplierEntity;
import com.example.booking.repositories.SupplierRepository;
import org.springframework.stereotype.Service;


@Service
public class SupplierDataService {
    private final SupplierRepository supplierRepository;

    public SupplierDataService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void save(SupplierEntity supplier) {
        supplierRepository.save(supplier);
    }
}
