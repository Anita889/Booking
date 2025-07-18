package com.example.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthRequestDTO {
    private String email;
    private String password;

    private String firstName;

    private String lastName;

    private String country;

    private String city;

    private String userType;
}

