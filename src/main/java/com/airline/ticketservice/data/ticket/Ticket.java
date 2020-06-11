package com.airline.ticketservice.data.ticket;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.data.flight.Flight;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity(name = "ticket")
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    private String ownerName;

    private String ownerSurname;

    private Integer ticketNumber;

    private String creditCartNumber;

    private BigDecimal ticketPrice;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
