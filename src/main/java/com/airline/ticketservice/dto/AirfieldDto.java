package com.airline.ticketservice.dto;

import com.airline.ticketservice.base.dto.AbstractDto;
import lombok.Data;

@Data
public class AirfieldDto extends AbstractDto {
    private String name;
    private String city;
}
