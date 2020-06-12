package com.airline.ticketservice.data.airfield;

import com.airline.ticketservice.base.data.repository.BaseRepository;

import java.util.Optional;

public interface AirfieldRepository extends BaseRepository<Airfield, Long> {

    Optional<Airfield> findByName(String name);
}
