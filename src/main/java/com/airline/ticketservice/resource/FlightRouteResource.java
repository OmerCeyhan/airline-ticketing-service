package com.airline.ticketservice.resource;

import com.airline.ticketservice.base.resource.AbstractResource;
import lombok.Data;


@Data
public class FlightRouteResource extends AbstractResource {

    private AirfieldResource fromAirfield;

    private AirfieldResource toAirfield;
}
