package com.airline.ticketservice.dto;

import com.airline.ticketservice.base.dto.AbstractDto;
import lombok.Data;

import java.util.List;

@Data
public class CompanyDto extends AbstractDto {
    private String name;

    List<FlightDto> flights;
}
