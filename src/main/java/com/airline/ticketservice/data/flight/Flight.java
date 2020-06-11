package com.airline.ticketservice.data.flight;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.constant.DataConstants;
import com.airline.ticketservice.data.company.Company;
import com.airline.ticketservice.data.route.FlightRoute;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "flight")
@Table(name = "flight")
public class Flight extends BaseEntity {

    private String name;

    private Integer numberOfCustomers = DataConstants.ZERO;

    private Integer customerQuota;

    private BigDecimal basePrice;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private FlightRoute flightRoute;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


}
