package com.airline.ticketservice.exception.advice;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponse {
    @NonNull
    private String errorMessage;
}
