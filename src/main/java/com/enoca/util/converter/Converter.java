package com.enoca.util.converter;

import com.enoca.dto.request.CreateCompanyRequest;
import com.enoca.dto.request.CreatePersonnelRequest;
import com.enoca.dto.response.*;
import com.enoca.entity.Company;
import com.enoca.entity.Personnel;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public Company toCompany(CreateCompanyRequest createCompanyRequest) {
        return Company.builder()
                .companyName(createCompanyRequest.getCompanyName())
                .taxId(createCompanyRequest.getTaxId())
                .webSite(createCompanyRequest.getWebSite())
                .type(createCompanyRequest.getType())
                .build();
    }

    public CreateCompanyResponse toCreateCompanyResponse(Company company) {
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
                .type(company.getType())
                .build();
    }

    public UpdateCompanyResponse toUpdateCompanyResponse(Company company) {
        return UpdateCompanyResponse.builder()
                .companyName(company.getCompanyName())
                .webSite(company.getWebSite())
                .taxId(company.getTaxId())
                .type(company.getType())
                .updatedDate(company.getLastModifiedDate())
                .build();
    }

    public Personnel toPersonnel(CreatePersonnelRequest request) {
        return Personnel.builder()
                .firstName(request.getFirstName())
                .identityNumber(request.getIdentityNumber())
                .lastName(request.getLastName())
                .build();
    }

    public CreatePersonnelResponse toCreatePersonResponse(Personnel personnel){
       return CreatePersonnelResponse.builder()
                .companyName(personnel.getCompany().getCompanyName())
                .firstName(personnel.getFirstName())
                .lastName(personnel.getLastName())
                .identityNumber(personnel.getIdentityNumber())
                .creationDate(personnel.getCreationDate())
                .build();
    }

    public UpdatePersonnelResponse toUpdatePersonnelResponse(Personnel personnel) {
        return UpdatePersonnelResponse.builder()
                .companyName(personnel.getCompany().getCompanyName())
                .firstName(personnel.getFirstName())
                .lastName(personnel.getLastName())
                .updatedDate(personnel.getLastModifiedDate())
                .identityNumber(personnel.getIdentityNumber())
                .build();
    }

    public GetAllPersonnelResponse toGetAllPersonnelResponse(Personnel personnel) {
        return GetAllPersonnelResponse.builder()
                .firstName(personnel.getFirstName())
                .lastName(personnel.getLastName())
                .identityNumber(personnel.getIdentityNumber())
                .build();
    }
}
