package com.airline.ticketservice.data.airfield;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "airfield")
@Table(name = "airfield")
public class Airfield extends BaseEntity {
}
