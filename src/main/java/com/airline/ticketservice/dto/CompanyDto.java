package com.airline.ticketservice.dto;

import com.airline.ticketservice.base.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyDto extends AbstractDto {
    private String name;
}
