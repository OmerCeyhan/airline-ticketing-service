package com.airline.ticketservice.controller.flight;

import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.controller.company.CompanyMapper;
import com.airline.ticketservice.controller.route.FlightRouteMapper;
import com.airline.ticketservice.data.flight.Flight;
import com.airline.ticketservice.dto.FlightDto;
import com.airline.ticketservice.resource.FlightResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {FlightRouteMapper.class, CompanyMapper.class})
public interface FlightMapper extends Converter<FlightDto, Flight, FlightResource> {

    @Override
    @Mappings({
            @Mapping(source = "company.name", target = "companyName"),
    })
    FlightResource toResource(Flight flight);
}
