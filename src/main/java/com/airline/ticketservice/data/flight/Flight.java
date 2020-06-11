package com.airline.ticketservice.data.flight;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.constant.DataConstants;
import com.airline.ticketservice.data.company.Company;
import com.airline.ticketservice.data.route.FlightRoute;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity(name = "flight")
@Table(name = "flight")
public class Flight extends BaseEntity {

    private String name;

    private Integer numberOfCustomers = DataConstants.ZERO;

    private Integer customerQuota;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private FlightRoute flightRoute;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


}
