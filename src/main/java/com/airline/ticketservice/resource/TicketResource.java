package com.airline.ticketservice.resource;

import com.airline.ticketservice.base.resource.AbstractResource;
import com.airline.ticketservice.type.TicketStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TicketResource extends AbstractResource {

    private String ownerName;

    private String ownerSurname;

    private String ticketNumber;

    private String creditCartNumber;

    private BigDecimal ticketPrice;

    private TicketStatus ticketStatus;

    private FlightResource flight;
}
