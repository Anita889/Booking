package com.example.booking.services;

import com.example.booking.dtos.HotelDTO;
import com.example.booking.dtos.HotelDateInfoDTO;
import com.example.booking.entities.HotelDateInfoEntity;
import com.example.booking.entities.HotelEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapperEntityToDTO {

    public static HotelDateInfoDTO getHotelDateInfoDTO(HotelDateInfoEntity hotelDateInfo){
        HotelDateInfoDTO infoDTO = new HotelDateInfoDTO();
        infoDTO.setId(hotelDateInfo.getId());
        List<String> dates = Arrays.stream(hotelDateInfo.getUnavailableDates().split(",")).toList();
        infoDTO.setUnavailableDates(dates);
        return infoDTO;
    }

    public static HotelDTO getHotelDTO(HotelEntity hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotel.getId());
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setCountry(hotel.getCountry());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setHotelDateInfos(getHotelDateInfoDTOS(hotel.getHotelDateInfos()));
        return hotelDTO;
    }
    public static List<HotelDTO> getHotelDTOS(List<HotelEntity> hotels) {
        List<HotelDTO> hotelDTOS = new ArrayList<>();
        for(HotelEntity hotel : hotels){
            HotelDTO hotelDTO = getHotelDTO(hotel);
            hotelDTOS.add(hotelDTO);
        }
        return hotelDTOS;
    }

    public static List<HotelDateInfoDTO> getHotelDateInfoDTOS(List<HotelDateInfoEntity> hotelDateInfos) {
        List<HotelDateInfoDTO> hotelDateInfoDTOS = new ArrayList<>();
        for (HotelDateInfoEntity hotelDate : hotelDateInfos){
            HotelDateInfoDTO infoDTO = getHotelDateInfoDTO(hotelDate);
            hotelDateInfoDTOS.add(infoDTO);
        }
        return hotelDateInfoDTOS;
    }
}
