package com.airline.ticketservice.data.flight;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "flight")
@Table(name = "flight")
public class Flight extends BaseEntity {
}
