package com.airline.ticketservice.controller.route;

import com.airline.ticketservice.base.controller.AbstractEntityController;
import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.route.FlightRoute;
import com.airline.ticketservice.dto.FlightRouteDto;
import com.airline.ticketservice.resource.FlightRouteResource;
import com.airline.ticketservice.service.FlightRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.airline.ticketservice.constant.WebConstants.API_PREFIX_URL;

@RestController
@RequestMapping(API_PREFIX_URL + "/flight-route")
public class FlightRouteController extends AbstractEntityController<FlightRouteDto, FlightRoute, FlightRouteResource, Long> {
    @Autowired
    private FlightRouteService flightRouteService;

    @Autowired
    private FlightRouteMapper flightRouteMapper;

    @Override
    protected AbstractEntityService<FlightRoute, Long> getService() {
        return flightRouteService;
    }

    @Override
    protected Converter<FlightRouteDto, FlightRoute, FlightRouteResource> getConverter() {
        return flightRouteMapper;
    }

    @GetMapping("/airfield-names")
    public FlightRouteResource getByAirfieldNames(
            @RequestParam("departureAirfieldName") String departureAirfieldName,
            @RequestParam("destinationAirfieldName") String destinationAirfieldName) {

        return toResource(flightRouteService.getByAirfieldNames(departureAirfieldName, destinationAirfieldName));
    }


    @GetMapping("/airfield-cities")
    public FlightRouteResource getByAirfieldCities(
            @RequestParam("departureAirfieldCity") String departureAirfieldCity,
            @RequestParam("destinationAirfieldCity") String destinationAirfieldCity) {
        return toResource(flightRouteService.getByAirfieldCities(departureAirfieldCity, destinationAirfieldCity));
    }
}
