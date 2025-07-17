package com.example.booking.dataservices;


import com.example.booking.repositories.HotelRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelDataService {
    private final HotelRepository hotelRepository;

    public HotelDataService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
}
