package com.airline.ticketservice.data.company;

import com.airline.ticketservice.base.data.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends BaseRepository<Company,Long> {

    Optional<Company> findByName(String name);
}
