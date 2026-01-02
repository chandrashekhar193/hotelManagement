package com.chandrashekhar.hotelManagement.exception;

import com.chandrashekhar.hotelManagement.DTO.CustomResponse;
import com.chandrashekhar.hotelManagement.DTO.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<CustomResponse> handleHotelValidationException(ValidationException ex) {
        CustomResponse response = new CustomResponse(ex.getStatusCode(), ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatusCode()));
    }
}
