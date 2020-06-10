package com.airline.ticketservice.service;

import com.airline.ticketservice.base.data.repository.BaseRepository;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.route.FlightRoute;
import com.airline.ticketservice.data.route.FlightRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightRouteService extends AbstractEntityService<FlightRoute, Long> {

    @Autowired
    private FlightRouteRepository flightRouteRepository;

    @Override
    public BaseRepository<FlightRoute, Long> getRepository() {
        return flightRouteRepository;
    }
}
