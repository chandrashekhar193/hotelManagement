package com.chandrashekhar.hotelManagement.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValidationException extends RuntimeException {
    private int statusCode;
    private String message;
    private Object data;

    public ValidationException(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }


    public ValidationException(int statusCode, String message) {
        this.statusCode=statusCode;
        this.message=message;
    }
}
