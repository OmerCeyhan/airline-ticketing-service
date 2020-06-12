package com.airline.ticketservice.controller.company;

import com.airline.ticketservice.base.controller.AbstractEntityController;
import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.company.Company;
import com.airline.ticketservice.dto.CompanyDto;
import com.airline.ticketservice.resource.CompanyResource;
import com.airline.ticketservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.airline.ticketservice.constant.WebConstants.API_PREFIX_URL;
@RestController
@RequestMapping(API_PREFIX_URL + "/company")
public class CompanyController extends AbstractEntityController<CompanyDto, Company, CompanyResource, Long> {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    protected AbstractEntityService<Company, Long> getService() {
        return companyService;
    }

    @Override
    protected Converter<CompanyDto, Company, CompanyResource> getConverter() {
        return companyMapper;
    }

    @GetMapping("/name/{name}")
    public CompanyResource getByName(@PathVariable("name")String name){
        return toResource(companyService.getByName(name));
    }
}
