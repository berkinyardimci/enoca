package com.enoca.service;

import com.enoca.dto.request.CreateCompanyRequest;
import com.enoca.dto.response.CreateCompanyResponse;
import com.enoca.entity.Company;
import com.enoca.repository.CompanyRepository;
import com.enoca.util.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class CompanyService{


    private final CompanyRepository companyRepository;
    private final Converter converter;

    public CompanyService(CompanyRepository companyRepository, Converter converter) {
        this.companyRepository = companyRepository;
        this.converter = converter;
    }

    public CreateCompanyResponse createCompany(CreateCompanyRequest createCompanyRequest) {
        Company company = converter.toCompany(createCompanyRequest);
        companyRepository.save(company);
        return converter.toCreateCompanyResponse(company);
    }
}
