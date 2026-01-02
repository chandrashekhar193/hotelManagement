package com.chandrashekhar.hotelManagement.customValidation;

import com.chandrashekhar.hotelManagement.DTO.HotelDto;
import com.chandrashekhar.hotelManagement.DTO.ValidationException;
import com.chandrashekhar.hotelManagement.repository.HotelRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelValidation  {
    @Autowired
    private HotelRepo hotelRepo;

    public void checkHotelValidation(HotelDto hotelDto) {

        if (hotelDto == null) {
            throw new ValidationException(400, "Provide all mandatory fields");
        }

        if (hotelDto.getName() == null || hotelDto.getName().trim().isEmpty()) {
            throw new ValidationException(400, "Please enter hotel name");
        }

        boolean isHotelExist = hotelRepo.existsByName(hotelDto.getName());
        if (isHotelExist) {
            throw new ValidationException(400, "Hotel already exists");
        }

        if (hotelDto.getLocation() == null || hotelDto.getLocation().trim().isEmpty()) {
            throw new ValidationException(400, "Location cannot be empty");
        }
    }


}
