package com.airline.ticketservice.resource;

import com.airline.ticketservice.base.resource.AbstractResource;
import lombok.Data;


@Data
public class CompanyResource extends AbstractResource {
    private String name;
}
