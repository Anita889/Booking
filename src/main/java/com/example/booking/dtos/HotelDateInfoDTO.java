package com.example.booking.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelDateInfoDTO {
    private Long id;
    private List<String> unavailableDates;
}
