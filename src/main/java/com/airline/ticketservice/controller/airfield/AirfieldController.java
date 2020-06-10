package com.airline.ticketservice.controller.airfield;

import com.airline.ticketservice.base.controller.AbstractEntityController;
import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.airfield.Airfield;
import com.airline.ticketservice.dto.AirfieldDto;
import com.airline.ticketservice.resource.AirfieldResource;
import com.airline.ticketservice.service.AirfieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.airline.ticketservice.constant.WebConstants.API_PREFIX_URL;

@RestController
@RequestMapping(API_PREFIX_URL + "/airfield")
public class AirfieldController extends AbstractEntityController<AirfieldDto, Airfield, AirfieldResource, Long> {

    @Autowired
    private AirfieldService airfieldService;

    @Autowired
    private AirfieldMapper airfieldMapper;

    @Override
    protected AbstractEntityService<Airfield, Long> getService() {
        return airfieldService;
    }

    @Override
    protected Converter<AirfieldDto, Airfield, AirfieldResource> getConverter() {
        return airfieldMapper;
    }
}
