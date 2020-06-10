package com.airline.ticketservice.resource;

import com.airline.ticketservice.base.resource.AbstractResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyResource extends AbstractResource {
    private String name;
}
