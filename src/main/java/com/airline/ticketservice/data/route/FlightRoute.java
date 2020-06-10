package com.airline.ticketservice.data.route;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "flight_route")
@Table(name = "flight_route")
public class FlightRoute extends BaseEntity {
}
