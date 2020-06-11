package com.airline.ticketservice.data.route;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.data.airfield.Airfield;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "flight_route")
@Table(name = "flight_route")
public class FlightRoute extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "from_airfield_id")
    private Airfield fromAirfield;

    @OneToOne
    @JoinColumn(name = "to_airfield_id")
    private Airfield toAirfield;
}
