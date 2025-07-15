package com.example.booking.dataservices;


import com.example.booking.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelDataService {
    @Autowired
    private HotelRepository hotelRepository;
}
