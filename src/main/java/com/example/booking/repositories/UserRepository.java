package com.example.booking.repositories;

import com.example.booking.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);

    void removeById(Long id);

    Optional<UserEntity> findByEmail(String email);
}
