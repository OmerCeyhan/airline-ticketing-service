package com.airline.ticketservice.data.ticket;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "ticket")
@Table(name = "ticket")
public class Ticket extends BaseEntity {
}
