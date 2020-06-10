package com.airline.ticketservice.data.company;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "company")
@Table(name = "company")
public class Company extends BaseEntity {

    @Column(name = "name")
    private String name;

}
