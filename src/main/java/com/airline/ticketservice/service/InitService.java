package com.airline.ticketservice.service;

import com.airline.ticketservice.data.airfield.Airfield;
import com.airline.ticketservice.data.company.Company;
import com.airline.ticketservice.data.flight.Flight;
import com.airline.ticketservice.data.route.FlightRoute;
import com.airline.ticketservice.data.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Service
public class InitService {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AirfieldService airfieldService;

    @Autowired
    private FlightRouteService flightRouteService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private TicketService ticketService;

    @PostConstruct
    public void init() {
        Company company = new Company();
        company.setName("Pegasus");
        companyService.save(company);

        Airfield istanbulAirfield = new Airfield("Istanbul Havalimanı", "Istanbul");
        airfieldService.save(istanbulAirfield);

        Airfield malatyaAirfield = new Airfield("Malatya Havalimanı", "Malatya");
        airfieldService.save(malatyaAirfield);

        FlightRoute route = new FlightRoute(istanbulAirfield, malatyaAirfield);
        flightRouteService.save(route);

        Flight flight = new Flight("PG-111", 0, 100, new BigDecimal("125.00"), route, company);
        flightService.save(flight);

        int i = 1;
        for (; i <= 9; i++) {
            ticketService.save(new Ticket("name-" + i, "surname-" + i, "123412341234123" + i, flight));
        }
        for (; i <= 20; i++) {
            ticketService.save(new Ticket("name-" + i, "surname-" + i, "1234-1234-1234-12" + i, flight));
        }
        for (; i <= 40; i++) {
            ticketService.save(new Ticket("name-" + i, "surname-" + i, "1234,1234,1234,12" + i, flight));
        }
    }

}