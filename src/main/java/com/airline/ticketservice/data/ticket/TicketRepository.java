package com.airline.ticketservice.data.ticket;

import com.airline.ticketservice.base.data.repository.BaseRepository;

import java.util.Optional;

public interface TicketRepository extends BaseRepository<Ticket, Long> {

    Optional<Ticket> findByTicketNumber(String ticketNumber);
}
