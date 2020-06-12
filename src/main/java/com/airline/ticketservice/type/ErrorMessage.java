package com.airline.ticketservice.type;

public enum ErrorMessage {
    //NULL FIELDS
    FLIGHT_COULD_NOT_FOUND("Flight could not be found!"),
    TICKET_COULD_NOT_FOUND("Ticket could not be found"),

    //OPERATIONAL
    FALSE_CREDIT_CARD_FORMAT("Credit cart format is false!"),
    FLIGHT_QUOTA_FULL("Ticket Limit Exceeded");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
