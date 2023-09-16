package com.enoca.service;

import com.enoca.entity.Company;
import com.enoca.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends ServiceManager<Company,Long> {

    private final CompanyRepository companyRepository;
    public CompanyService(CompanyRepository companyRepository) {
        super(companyRepository);
        this.companyRepository = companyRepository;
    }
}
