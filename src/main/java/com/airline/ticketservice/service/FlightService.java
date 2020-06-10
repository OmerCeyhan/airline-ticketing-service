package com.airline.ticketservice.service;

import com.airline.ticketservice.base.data.repository.BaseRepository;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.flight.Flight;
import com.airline.ticketservice.data.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends AbstractEntityService<Flight, Long> {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public BaseRepository<Flight, Long> getRepository() {
        return flightRepository;
    }
}
