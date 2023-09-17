package com.enoca.util.converter;

import com.enoca.dto.request.CreateCompanyRequest;
import com.enoca.dto.response.CreateCompanyResponse;
import com.enoca.dto.response.GetAllCompanyResponse;
import com.enoca.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public Company toCompany(CreateCompanyRequest createCompanyRequest){
            return Company.builder()
                    .companyName(createCompanyRequest.getCompanyName())
                    .taxId(createCompanyRequest.getTaxId())
                    .webSite(createCompanyRequest.getWebSite())
                    .type(createCompanyRequest.getType())
                    .build();
    }

    public CreateCompanyResponse toCreateCompanyResponse(Company company){
        CreateCompanyResponse response = new CreateCompanyResponse();
        response.setCompanyName(company.getCompanyName());
        response.setId(company.getId());
        response.setWebSite(company.getWebSite());
        response.setType(company.getType());
        response.setTaxId(company.getTaxId());
        return response;
    }

    public GetAllCompanyResponse toGetAllCompanyResponse(Company company) {
        return GetAllCompanyResponse.builder()
                .companyName(company.getCompanyName())
                .creationDate(company.getCreationDate())
                .updateDate(company.getLastModifiedDate())
                .taxId(company.getTaxId())
                .webSite(company.getWebSite())
                .build();
    }
}
