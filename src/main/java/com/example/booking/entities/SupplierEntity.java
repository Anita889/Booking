package com.example.booking.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    @ManyToMany
    @JoinTable(
            name = "supplier_hotels",
            joinColumns = @JoinColumn(
                    name = "supplier_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "hotel_id", referencedColumnName = "id"))
    @OnDelete(action =  OnDeleteAction.NO_ACTION)
    private List<HotelEntity> hotels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<HotelEntity> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelEntity> hotels) {
        this.hotels = hotels;
    }
}
