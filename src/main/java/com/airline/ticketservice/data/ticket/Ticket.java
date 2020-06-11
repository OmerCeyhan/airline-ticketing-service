package com.airline.ticketservice.data.ticket;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.data.flight.Flight;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ticket")
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    private String ownerName;

    private String ownerSurname;

    private String ticketNumber;

    private String creditCartNumber;

    private BigDecimal ticketPrice;

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
