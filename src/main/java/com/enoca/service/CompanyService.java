package com.enoca.service;

import com.enoca.dto.request.CreateCompanyRequest;
import com.enoca.dto.response.CreateCompanyResponse;
import com.enoca.entity.Company;
import com.enoca.repository.CompanyRepository;
import com.enoca.util.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService extends ServiceManager<Company, Long> {


    private final CompanyRepository companyRepository;
    private final Converter converter;

    public CompanyService(CompanyRepository companyRepository, Converter converter) {
        super(companyRepository);
        this.companyRepository = companyRepository;
        this.converter = converter;
    }

    public CreateCompanyResponse createCompany(CreateCompanyRequest createCompanyRequest) {
        validateCompanyInformation(createCompanyRequest);
        Company company = converter.toCompany(createCompanyRequest);
        
        try {
            save(company);
        } catch (Exception e) {
            throw new RuntimeException("Kaydetme Başarısız");
        }
        CreateCompanyResponse response = converter.toCreateCompanyRespone(company);
        return response;
    }

    private void validateCompanyInformation(CreateCompanyRequest createCompanyRequest) {
        companyRepository.findByCompanyName(createCompanyRequest.getCompanyName())
                .ifPresent(existingCompany -> {
                    throw new RuntimeException("Şirket adı zaten kayıtlı.");
                });

        companyRepository.findByTaxId(createCompanyRequest.getTaxId())
                .ifPresent(existingCompany -> {
                    throw new RuntimeException("Vergi kimlik numarası zaten kayıtlı.");
                });

        companyRepository.findByWebSite(createCompanyRequest.getWebSite())
                .ifPresent(existingCompany -> {
                    throw new RuntimeException("Web sitesi zaten kayıtlı.");
                });
    }
}
