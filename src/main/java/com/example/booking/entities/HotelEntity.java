package com.example.booking.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.List;

@Entity
public class HotelEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @ManyToMany
    @JoinTable(
            name = "customer_hotels",
            joinColumns = @JoinColumn(
                    name = "hotel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "customer_id", referencedColumnName = "id"))
    @OnDelete(action =  OnDeleteAction.NO_ACTION)
    private List<CustomerEntity> customers;

    @ManyToMany
    @JoinTable(
            name = "supplier_hotels",
            joinColumns = @JoinColumn(
                    name = "hotel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "supplier_id", referencedColumnName = "id"))
    @OnDelete(action =  OnDeleteAction.NO_ACTION)
    private List<SupplierEntity> suppliers;

    @OneToMany(mappedBy = "hotel")
    private List<HotelDateInfoEntity> hotelDateInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<HotelDateInfoEntity> getHotelDateInfos() {
        return hotelDateInfos;
    }

    public void setHotelDateInfos(List<HotelDateInfoEntity> hotelDateInfos) {
        this.hotelDateInfos = hotelDateInfos;
    }

    public List<CustomerEntity> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerEntity> customers) {
        this.customers = customers;
    }

    public List<SupplierEntity> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierEntity> suppliers) {
        this.suppliers = suppliers;
    }
}

