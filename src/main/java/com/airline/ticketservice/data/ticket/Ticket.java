package com.airline.ticketservice.data.ticket;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.data.flight.Flight;
import com.airline.ticketservice.type.TicketStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ticket")
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    @NotNull(message = "Customer name must be entered")
    private String ownerName;

    @NotNull(message = "Customer surname must be entered")
    private String ownerSurname;

    private String ticketNumber;

    @NotNull(message = "Credit card must be entered")
    private String creditCartNumber;

    @NotNull(message = "Ticket price cannot be null")
    private BigDecimal ticketPrice;

    @NotNull(message = "Ticket status cannot be null")
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus = TicketStatus.ACTIVE;

    @NotNull(message = "Ticket must be connected to a flight")
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;


    public Ticket(String ownerName, String ownerSurname, String creditCartNumber, Flight flight) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.creditCartNumber = creditCartNumber;
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", ticketNumber=" + ticketNumber +
                ", creditCartNumber='" + creditCartNumber + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
