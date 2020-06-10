package com.airline.ticketservice.controller.airfield;

import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.data.airfield.Airfield;
import com.airline.ticketservice.dto.AirfieldDto;
import com.airline.ticketservice.resource.AirfieldResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirfieldMapper extends Converter<AirfieldDto, Airfield, AirfieldResource> {
}
