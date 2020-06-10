package com.airline.ticketservice.controller.company;

import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.data.company.Company;
import com.airline.ticketservice.dto.CompanyDto;
import com.airline.ticketservice.resource.CompanyResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends Converter<CompanyDto, Company, CompanyResource> {
}
