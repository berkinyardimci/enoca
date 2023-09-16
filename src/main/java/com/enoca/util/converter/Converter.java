package com.enoca.util.converter;

import com.enoca.dto.request.CreateCompanyRequest;
import com.enoca.dto.response.CreateCompanyResponse;
import com.enoca.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public Company toCompany(CreateCompanyRequest createCompanyRequest){

        if(createCompanyRequest != null){
            Company company = Company.builder()
                    .companyName(createCompanyRequest.getCompanyName())
                    .taxId(createCompanyRequest.getTaxId())
                    .webSite(createCompanyRequest.getWebSite())
                    .type(createCompanyRequest.getType())
                    .build();
            return company;
        }else
            throw new RuntimeException("Null olamaz");
    }

    public CreateCompanyResponse toCreateCompanyRespone(Company company){
        CreateCompanyResponse response = new CreateCompanyResponse();
        response.setCompanyName(company.getCompanyName());
        response.setId(company.getId());
        response.setWebSite(company.getWebSite());
        response.setType(company.getType());
        response.setTaxId(company.getTaxId());
        return response;

    }
}
