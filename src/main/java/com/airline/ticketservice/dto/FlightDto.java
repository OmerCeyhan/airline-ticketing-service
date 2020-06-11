package com.airline.ticketservice.dto;

import com.airline.ticketservice.base.dto.AbstractDto;
import lombok.Data;

@Data
public class FlightDto extends AbstractDto {

    private String name;

    private Integer numberOfCustomers;

    private Integer customerQuota;

    private FlightRouteDto flightRoute;

    private CompanyDto company;
}
