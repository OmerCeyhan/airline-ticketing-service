package com.airline.ticketservice.data.route;

import com.airline.ticketservice.base.data.repository.BaseRepository;

import java.util.Optional;

public interface FlightRouteRepository extends BaseRepository<FlightRoute, Long> {

    Optional<FlightRoute> findByFromAirfield_NameAndToAirfield_Name(String departureAirfieldName, String destinationAirfieldName);


    Optional<FlightRoute> findByFromAirfield_CityAndToAirfield_City(String departureAirfieldCity, String destinationAirfieldCity);
}
