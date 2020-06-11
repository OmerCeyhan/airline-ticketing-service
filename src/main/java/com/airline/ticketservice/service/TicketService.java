package com.airline.ticketservice.service;

import com.airline.ticketservice.base.data.repository.BaseRepository;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.flight.Flight;
import com.airline.ticketservice.data.ticket.Ticket;
import com.airline.ticketservice.data.ticket.TicketRepository;
import com.airline.ticketservice.util.TicketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends AbstractEntityService<Ticket, Long> {

    @Autowired
    private FlightService flightService;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public BaseRepository<Ticket, Long> getRepository() {
        return ticketRepository;
    }

    @Override
    public Ticket save(Ticket entity) {
        Flight flight = flightService.getEntity(entity.getFlight().getId());
        if (flight == null) {
            // TODO: 11.06.2020  throw new BadRequestException()
        }
        entity.setTicketPrice(TicketUtils.calculateTicketPrice(flight.getBasePrice(), flight.getCustomerQuota(), flight.getNumberOfCustomers()));
        String formattedCreditCardNumber = TicketUtils.formatCreditCardNumber(entity.getCreditCartNumber());
        entity.setCreditCartNumber(formattedCreditCardNumber);
        flight.setNumberOfCustomers(flight.getNumberOfCustomers() + 1);
        flightService.put(flight.getId(), flight);
        entity = super.save(entity);
        entity.setTicketNumber(flight.getName() + entity.getId());
        return put(entity.getId(), entity);
    }
}
