package com.airline.ticketservice.dto;

import com.airline.ticketservice.base.dto.AbstractDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TicketDto extends AbstractDto {

    private String ownerName;

    private String ownerSurname;

    private Integer ticketNumber;

    private String creditCartNumber;

    private BigDecimal ticketPrice;

    private FlightDto flight;
}
