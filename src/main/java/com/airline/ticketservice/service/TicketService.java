package com.airline.ticketservice.service;

import com.airline.ticketservice.base.data.repository.BaseRepository;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.ticket.Ticket;
import com.airline.ticketservice.data.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends AbstractEntityService<Ticket, Long> {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public BaseRepository<Ticket, Long> getRepository() {
        return ticketRepository;
    }
}
