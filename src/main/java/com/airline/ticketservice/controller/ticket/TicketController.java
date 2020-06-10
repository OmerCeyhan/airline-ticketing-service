package com.airline.ticketservice.controller.ticket;

import com.airline.ticketservice.base.controller.AbstractEntityController;
import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.ticket.Ticket;
import com.airline.ticketservice.dto.TicketDto;
import com.airline.ticketservice.resource.TicketResource;
import com.airline.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.airline.ticketservice.constant.WebConstants.API_PREFIX_URL;

@RestController
@RequestMapping(API_PREFIX_URL + "/ticket")
public class TicketController extends AbstractEntityController<TicketDto, Ticket, TicketResource, Long> {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    protected AbstractEntityService<Ticket, Long> getService() {
        return ticketService;
    }

    @Override
    protected Converter<TicketDto, Ticket, TicketResource> getConverter() {
        return ticketMapper;
    }
}
