package com.airline.ticketservice.controller.flight;

import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.data.company.Company;
import com.airline.ticketservice.data.flight.Flight;
import com.airline.ticketservice.data.route.FlightRoute;
import com.airline.ticketservice.dto.FlightDto;
import com.airline.ticketservice.resource.FlightResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FlightRoute.class, Company.class})
public interface FlightMapper extends Converter<FlightDto, Flight, FlightResource> {
}
