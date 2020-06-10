package com.airline.ticketservice.controller.ticket;

import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.data.ticket.Ticket;
import com.airline.ticketservice.dto.TicketDto;
import com.airline.ticketservice.resource.TicketResource;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TicketMapper extends Converter<TicketDto, Ticket, TicketResource> {
}
