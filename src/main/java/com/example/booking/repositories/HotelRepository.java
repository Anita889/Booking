package com.example.booking.repositories;

import com.example.booking.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    Optional<HotelEntity> findById(Long id);

    void removeById(Long id);
}