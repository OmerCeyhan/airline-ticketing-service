package com.airline.ticketservice.exception;

import com.airline.ticketservice.type.ErrorMessage;
import org.springframework.http.HttpStatus;

public class BadRequestException extends AbstractCustomRuntimeException {

    public BadRequestException(ErrorMessage errorMessage) {
        super(errorMessage,HttpStatus.BAD_REQUEST);
    }
}
