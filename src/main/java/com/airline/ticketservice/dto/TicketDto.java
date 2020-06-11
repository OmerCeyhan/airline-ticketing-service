package com.airline.ticketservice.dto;

import com.airline.ticketservice.base.dto.AbstractDto;
import lombok.Data;

@Data
public class TicketDto extends AbstractDto {

    private String ownerName;

    private String ownerSurname;

    private String creditCartNumber;

    private FlightDto flight;
}
