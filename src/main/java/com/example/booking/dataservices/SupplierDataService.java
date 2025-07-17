package com.example.booking.dataservices;

import com.example.booking.entities.SupplierEntity;
import com.example.booking.repositories.SupplierRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SupplierDataService {
    private final SupplierRepository supplierRepository;

    public SupplierDataService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void save(SupplierEntity supplier) {
        supplierRepository.save(supplier);
    }

    public SupplierEntity findById(Long supplierId) {
        Optional<SupplierEntity> supplier = supplierRepository.findById(supplierId);
        if(supplier.isEmpty()){
            throw new UsernameNotFoundException("Supplier with " + supplierId + " does not exist");
        }
        return supplier.get();
    }
}
