package com.airline.ticketservice.service;

import com.airline.ticketservice.base.data.repository.BaseRepository;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.airfield.Airfield;
import com.airline.ticketservice.data.airfield.AirfieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirfieldService extends AbstractEntityService<Airfield,Long> {

    @Autowired
    private AirfieldRepository airfieldRepository;

    @Override
    public BaseRepository<Airfield, Long> getRepository() {
        return airfieldRepository;
    }
}
