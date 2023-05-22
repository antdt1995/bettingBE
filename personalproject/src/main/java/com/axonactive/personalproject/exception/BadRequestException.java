package com.axonactive.personalproject.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ResponseException{
    public BadRequestException(String messageKey, String message, HttpStatus httpStatus) {
        super(messageKey, message, httpStatus);
    }

    public static BadRequestException badRequest(String messageKey, String message) {
        return new BadRequestException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

}
