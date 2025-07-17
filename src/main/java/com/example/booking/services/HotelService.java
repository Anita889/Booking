package com.example.booking.services;


import com.example.booking.dataservices.HotelDataService;
import com.example.booking.dtos.HotelDTO;
import com.example.booking.entities.HotelEntity;
import com.example.booking.entities.SupplierEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class HotelService {
    private final HotelDataService hotelDataService;

    public HotelService(HotelDataService hotelDataService) {
        this.hotelDataService = hotelDataService;
    }

    public HotelEntity create(HotelDTO hotel, SupplierEntity supplier) {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(hotel.getId());
        hotelEntity.setHotelName(hotel.getHotelName());
        hotelEntity.setCountry(hotel.getCountry());
        hotelEntity.setCity(hotel.getCity());
        hotelEntity.setAddress(hotel.getAddress());
        hotelEntity.setSuppliers(Collections.singletonList(supplier));
        hotelDataService.save(hotelEntity);
        return hotelEntity;
    }

    public void update(HotelEntity hotelEntity, HotelDTO hotelDTO) {
        //TODO:
    }
}
