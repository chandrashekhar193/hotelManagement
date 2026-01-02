package com.chandrashekhar.hotelManagement.serviceImpl;

import com.chandrashekhar.hotelManagement.DTO.CustomResponse;
import com.chandrashekhar.hotelManagement.DTO.HotelDto;
import com.chandrashekhar.hotelManagement.DTO.ValidationException;
import com.chandrashekhar.hotelManagement.customValidation.HotelValidation;
import com.chandrashekhar.hotelManagement.entity.Hotel;
import com.chandrashekhar.hotelManagement.repository.HotelRepo;
import com.chandrashekhar.hotelManagement.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepo hotelRepo;
    private final HotelValidation hotelValidation;

    public HotelServiceImpl(HotelRepo hotelRepo, HotelValidation hotelValidation) {
        this.hotelRepo = hotelRepo;
        this.hotelValidation = hotelValidation;
    }

    @Override
    public CustomResponse createHotel(HotelDto hotelDto) {
        try {
            hotelValidation.checkHotelValidation(hotelDto);

            Hotel hotelEntity = hotelDto.hotelDtoToEntity(hotelDto);
            hotelRepo.save(hotelEntity);

            HotelDto returnHotel = hotelDto.hotelEntityToDto(hotelEntity);
            return new CustomResponse(HttpStatus.CREATED.value(), "Hotel created successfully", returnHotel);
        } catch (ValidationException ex) {
            return new CustomResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        } catch (Exception e) {
            return new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to create hotel", null);
        }
    }

    @Override
    public CustomResponse updateHotel(HotelDto hotelDto) {
        try {
            hotelValidation.checkHotelValidation(hotelDto);
            if (hotelDto.getId() == null) {
                return new CustomResponse(HttpStatus.BAD_REQUEST.value(), "Hotel ID is required for update", null);
            }
            Optional<Hotel> existingHotelOpt = hotelRepo.findById(hotelDto.getId());
            if (existingHotelOpt.isEmpty()) {
                return new CustomResponse(HttpStatus.NOT_FOUND.value(), "Hotel not found", null);
            }

            Hotel existing = existingHotelOpt.get();
            existing.setName(hotelDto.getName());
            existing.setLocation(hotelDto.getLocation());
            existing.setAbout(hotelDto.getAbout());

            hotelRepo.save(existing);

            return new CustomResponse(HttpStatus.OK.value(), "Hotel updated successfully", null);
        } catch (Exception e) {
            return new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to update hotel", null);
        }
    }

    @Override
    public CustomResponse getHotelById(Long id) {
        HotelDto hotelDto=new HotelDto();
        try {
            if (id == null || id <= 0) {
                return new CustomResponse(HttpStatus.BAD_REQUEST.value(), "Invalid hotel ID", null);
            }

            Optional<Hotel> hotelOpt = hotelRepo.findById(id);
            if (hotelOpt.isEmpty()) {
                return new CustomResponse(HttpStatus.NOT_FOUND.value(), "Hotel not found", null);
            }
            HotelDto dto = hotelDto.hotelEntityToDto(hotelOpt.get());
            return new CustomResponse(HttpStatus.OK.value(), "Hotel fetched successfully", dto);
        } catch (Exception e) {
            return new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to fetch hotel", null);
        }
    }

    @Override
    public CustomResponse getAllHotel() {
        List<Hotel> hotelList = hotelRepo.findAll();
        List<HotelDto> hotelDtoList = new ArrayList<>();
        HotelDto hotelDto=new HotelDto();
        for (Hotel hotel : hotelList) {

            hotelDtoList.add(hotelDto.hotelEntityToDto(hotel));
        }
        return new CustomResponse(HttpStatus.OK.value(), "Hotels fetched successfully", hotelDtoList);
    }

    @Override
    public CustomResponse deleteHotel(Long id) {
        try {
            if (id == null || id <= 0) {
                return new CustomResponse(HttpStatus.BAD_REQUEST.value(), "Invalid hotel ID", null);
            }

            if (!hotelRepo.existsById(id)) {
                return new CustomResponse(HttpStatus.NOT_FOUND.value(), "Hotel not found", null);
            }

            hotelRepo.deleteById(id);

            return new CustomResponse(HttpStatus.OK.value(), "Hotel deleted successfully", null);
        } catch (Exception e) {
            return new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to delete hotel", null);
        }
    }
}
