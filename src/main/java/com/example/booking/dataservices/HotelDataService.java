package com.example.booking.dataservices;

import com.example.booking.entities.HotelEntity;
import com.example.booking.repositories.HotelRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelDataService {
    private final HotelRepository hotelRepository;

    public HotelDataService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void save(HotelEntity hotelEntity) {
        hotelRepository.save(hotelEntity);
    }

    public HotelEntity findById(Long hotelId) {
        Optional<HotelEntity> hotel = hotelRepository.findById(hotelId);
        if(hotel.isEmpty()){
            throw new UsernameNotFoundException("Hotel with " + hotelId + " does not exist");
        }
        return hotel.get();
    }

    public void remove(Long hotelId) {
        hotelRepository.removeById(hotelId);
    }
}
