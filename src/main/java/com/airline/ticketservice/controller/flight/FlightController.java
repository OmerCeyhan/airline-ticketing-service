package com.airline.ticketservice.controller.flight;

import com.airline.ticketservice.base.controller.AbstractEntityController;
import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.flight.Flight;
import com.airline.ticketservice.dto.FlightDto;
import com.airline.ticketservice.resource.FlightResource;
import com.airline.ticketservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.airline.ticketservice.constant.WebConstants.API_PREFIX_URL;

@RestController
@RequestMapping(API_PREFIX_URL + "/flight")
public class FlightController extends AbstractEntityController<FlightDto, Flight, FlightResource, Long> {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMapper flightMapper;

    @Override
    protected AbstractEntityService<Flight, Long> getService() {
        return flightService;
    }

    @Override
    protected Converter<FlightDto, Flight, FlightResource> getConverter() {
        return flightMapper;
    }
}
