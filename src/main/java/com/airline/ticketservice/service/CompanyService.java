package com.airline.ticketservice.service;

import com.airline.ticketservice.base.data.repository.BaseRepository;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.data.company.Company;
import com.airline.ticketservice.data.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService extends AbstractEntityService<Company, Long> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public BaseRepository<Company, Long> getRepository() {
        return companyRepository;
    }

    public Optional<Company> getByName(String name) {
        return companyRepository.findByName(name);
    }
}
