package com.example.booking.entities;

import jakarta.persistence.*;

@Entity
public class HotelDateInfoEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unavailable_dates")
    private String unavailableDates;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnavailableDates() {
        return unavailableDates;
    }

    public void setUnavailableDates(String unavailableDates) {
        this.unavailableDates = unavailableDates;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }
}
