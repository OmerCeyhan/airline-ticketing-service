package com.airline.ticketservice.controller.route;

import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.controller.airfield.AirfieldMapper;
import com.airline.ticketservice.data.route.FlightRoute;
import com.airline.ticketservice.dto.FlightRouteDto;
import com.airline.ticketservice.resource.FlightRouteResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AirfieldMapper.class})
public interface FlightRouteMapper extends Converter<FlightRouteDto, FlightRoute, FlightRouteResource> {
}
