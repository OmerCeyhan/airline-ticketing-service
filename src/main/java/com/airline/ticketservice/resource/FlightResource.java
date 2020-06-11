package com.airline.ticketservice.resource;

import com.airline.ticketservice.base.resource.AbstractResource;
import lombok.Data;

@Data
public class FlightResource extends AbstractResource {

    private String name;

    private Integer numberOfCustomers;

    private Integer customerQuota;

    private FlightRouteResource flightRoute;

    private CompanyResource company;
}
