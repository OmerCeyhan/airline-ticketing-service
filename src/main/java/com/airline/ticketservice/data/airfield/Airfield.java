package com.airline.ticketservice.data.airfield;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "airfield")
@Table(name = "airfield")
public class Airfield extends BaseEntity {

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "City cannot be null")
    private String city;
}
