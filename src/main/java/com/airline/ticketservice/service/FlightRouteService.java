package com.airline.ticketservice.service;

import com.airline.ticketservice.base.data.repository.BaseRepository;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.route.FlightRoute;
import com.airline.ticketservice.data.route.FlightRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightRouteService extends AbstractEntityService<FlightRoute, Long> {

    @Autowired
    private FlightRouteRepository flightRouteRepository;

    @Override
    public BaseRepository<FlightRoute, Long> getRepository() {
        return flightRouteRepository;
    }

    public Optional<FlightRoute> getByAirfieldNames(String departureAirfieldName, String destinationAirfieldName) {
        return flightRouteRepository.findByFromAirfield_NameAndToAirfield_Name(departureAirfieldName, destinationAirfieldName);
    }

    public Optional<FlightRoute> getByAirfieldCities(String departureAirfieldCity, String destinationAirfieldCity) {
        return flightRouteRepository.findByFromAirfield_CityAndToAirfield_City(departureAirfieldCity, destinationAirfieldCity);
    }
}
