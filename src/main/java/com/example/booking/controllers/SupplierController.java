package com.example.booking.controllers;


import com.example.booking.dataservices.HotelDataService;
import com.example.booking.dataservices.SupplierDataService;
import com.example.booking.dtos.HotelDTO;
import com.example.booking.entities.HotelEntity;
import com.example.booking.entities.SupplierEntity;
import com.example.booking.services.HotelService;
import com.example.booking.services.MapperEntityToDTO;
import com.example.booking.services.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierDataService supplierDataService;

    private final SupplierService supplierService;
    private final HotelService hotelService;
    private final HotelDataService hotelDataService;

    public SupplierController(SupplierDataService supplierDataService, SupplierService supplierService, HotelService hotelService, HotelDataService hotelDataService) {
        this.supplierDataService = supplierDataService;
        this.supplierService = supplierService;
        this.hotelService = hotelService;
        this.hotelDataService = hotelDataService;
    }

    @RequestMapping(value = "{supplierId}/hotels", method = RequestMethod.GET)
    public ResponseEntity<?> getHotels(@PathVariable Long supplierId){
        SupplierEntity supplier = supplierDataService.findById(supplierId);
        List<HotelDTO> hotelDTOS = new ArrayList<>();
        if(!supplier.getHotels().isEmpty()){
            hotelDTOS = MapperEntityToDTO.getHotelDTOS(supplier.getHotels());
        }
        return ResponseEntity.ok(hotelDTOS);
    }

    @RequestMapping(value = "{supplierId}/hotels/add", method = RequestMethod.POST)
    public ResponseEntity<?> addHotel(@PathVariable Long supplierId, @RequestBody HotelDTO hotelDTO){
        SupplierEntity supplier = supplierDataService.findById(supplierId);
        hotelService.create(hotelDTO, supplier);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "{supplierId}/hotels/{hotelId}", method = RequestMethod.GET)
    public ResponseEntity<?> getHotelById(@PathVariable Long supplierId, @PathVariable Long hotelId) {
        SupplierEntity supplier = supplierDataService.findById(supplierId);
        HotelEntity hotel = hotelDataService.findById(hotelId);
        HotelDTO hotelDTO = MapperEntityToDTO.getHotelDTOS(Collections.singletonList(hotel)).get(0);
        return ResponseEntity.ok(hotelDTO);
    }

    @RequestMapping(value = "{supplierId}/hotels/{hotelId}/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateHotel(@PathVariable Long supplierId,
                                         @PathVariable Long hotelId,
                                         @RequestBody HotelDTO hotelDTO) {
        SupplierEntity supplier = supplierDataService.findById(supplierId);
        HotelEntity hotel = hotelDataService.findById(hotelId);
        hotelService.update(hotel, hotelDTO);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "{supplierId}/hotels/{hotelId}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteHotel(@PathVariable Long supplierId,
                                         @PathVariable Long hotelId) {
        SupplierEntity supplier = supplierDataService.findById(supplierId);
        HotelEntity hotel = hotelDataService.findById(hotelId);
        hotelDataService.remove(hotelId);
        return ResponseEntity.ok(true);
    }

}
