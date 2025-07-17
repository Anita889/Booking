package com.example.booking.dtos;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelDTO {
    private Long id;

    private String hotelName;

    private String address;

    private String country;

    private String city;

    private List<HotelDateInfoDTO> hotelDateInfos;
}
