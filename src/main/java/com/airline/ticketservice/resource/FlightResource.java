package com.airline.ticketservice.resource;

import com.airline.ticketservice.base.resource.AbstractResource;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FlightResource extends AbstractResource {

    private String name;

    private Integer numberOfCustomers;

    private Integer customerQuota;

    private BigDecimal basePrice;

    private FlightRouteResource flightRoute;

    private String companyName;
}
