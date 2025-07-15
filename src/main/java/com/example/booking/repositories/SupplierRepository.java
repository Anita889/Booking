package com.example.booking.repositories;

import com.example.booking.entities.SupplierEntity;
import com.example.booking.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    Optional<SupplierEntity> findById(Long id);

    void removeById(Long id);
}

