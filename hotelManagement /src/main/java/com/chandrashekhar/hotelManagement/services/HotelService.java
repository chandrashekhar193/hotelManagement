package com.chandrashekhar.hotelManagement.services;

import com.chandrashekhar.hotelManagement.DTO.CustomResponse;
import com.chandrashekhar.hotelManagement.DTO.HotelDto;

import java.security.interfaces.RSAKey;

public interface HotelService {

    CustomResponse createHotel(HotelDto hotelDto);
    CustomResponse updateHotel(HotelDto hotelDto);;
    CustomResponse getHotelById(Long id);
    CustomResponse getAllHotel();
    CustomResponse deleteHotel(Long id);




}
