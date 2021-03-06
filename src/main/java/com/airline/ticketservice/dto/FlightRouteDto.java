package com.airline.ticketservice.dto;

import com.airline.ticketservice.base.dto.AbstractDto;
import lombok.Data;

@Data
public class FlightRouteDto extends AbstractDto {

    private AirfieldDto fromAirfield;

    private AirfieldDto toAirfield;
}
