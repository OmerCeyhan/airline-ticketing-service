package com.airline.ticketservice.exception.advice;

import com.airline.ticketservice.exception.AbstractCustomRuntimeException;
import com.airline.ticketservice.exception.BadRequestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class, RuntimeException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ex.getMessage());
        HttpStatus httpStatus = ex instanceof AbstractCustomRuntimeException ? ((AbstractCustomRuntimeException) ex).getHttpStatus() : HttpStatus.INTERNAL_SERVER_ERROR;
        return handleExceptionInternal(ex, response, new HttpHeaders(), httpStatus, request);
    }
}
