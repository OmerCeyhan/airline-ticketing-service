package com.airline.ticketservice.dto;

import com.airline.ticketservice.base.dto.AbstractDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FlightDto extends AbstractDto {

    private String name;

    private Integer customerQuota;

    private BigDecimal basePrice;

    private FlightRouteDto flightRoute;

    private CompanyDto company;
}
