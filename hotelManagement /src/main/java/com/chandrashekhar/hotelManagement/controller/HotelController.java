package com.chandrashekhar.hotelManagement.controller;

import com.chandrashekhar.hotelManagement.DTO.CustomResponse;
import com.chandrashekhar.hotelManagement.DTO.HotelDto;
import com.chandrashekhar.hotelManagement.services.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/hotel")
public class HotelController {


    private final HotelService hotelService;

    public HotelController(HotelService hotelService){
        this.hotelService=hotelService;
    }
    // Create hotel
    @PostMapping
    public ResponseEntity<CustomResponse> createHotel(@RequestBody HotelDto hotelDto) {
        CustomResponse response = hotelService.createHotel(hotelDto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Update hotel
    @PutMapping
    public ResponseEntity<CustomResponse> updateHotel(@RequestBody HotelDto hotelDto) {
        CustomResponse response = hotelService.updateHotel(hotelDto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Get hotel by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getHotelById(@PathVariable Long id) {
        CustomResponse response = hotelService.getHotelById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Get all hotels
    @GetMapping
    public ResponseEntity<CustomResponse> getAllHotels() {
        CustomResponse response = hotelService.getAllHotel();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Delete hotel
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteHotel(@PathVariable Long id) {
        CustomResponse response = hotelService.deleteHotel(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }


}
