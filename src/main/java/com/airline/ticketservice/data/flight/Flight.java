package com.airline.ticketservice.data.flight;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.constant.DataConstants;
import com.airline.ticketservice.data.company.Company;
import com.airline.ticketservice.data.route.FlightRoute;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "flight")
@Table(name = "flight")
public class Flight extends BaseEntity {

    @NotNull(message = "You must define a name for this flight.")
    private String name;

    private Integer numberOfCustomers = DataConstants.ZERO;

    @NotNull(message = "You must define flight's customer quota.")
    private Integer customerQuota;

    @NotNull(message = "You must define flight's base price.")
    private BigDecimal basePrice;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private FlightRoute flightRoute;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Override
    public String toString() {
        return "Flight{" +
                "name='" + name + '\'' +
                ", numberOfCustomers=" + numberOfCustomers +
                ", customerQuota=" + customerQuota +
                ", basePrice=" + basePrice +
                ", flightRoute=" + flightRoute +
                ", rowVersion=" + rowVersion +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", id=" + id +
                '}';
    }
}
