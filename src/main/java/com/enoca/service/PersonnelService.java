package com.enoca.service;

import com.enoca.dto.request.CreatePersonnelRequest;
import com.enoca.dto.response.CreatePersonnelResponse;
import com.enoca.entity.Company;
import com.enoca.entity.Personnel;
import com.enoca.repository.CompanyRepository;
import com.enoca.repository.PersonnelRepository;
import com.enoca.util.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    private final CompanyRepository companyRepository;
    private final Converter converter;
    public PersonnelService(PersonnelRepository personnelRepository, CompanyRepository companyRepository, Converter converter) {
        this.personnelRepository = personnelRepository;
        this.companyRepository = companyRepository;
        this.converter = converter;
    }

    public CreatePersonnelResponse savePerson(CreatePersonnelRequest request){
        Optional<Company> company = companyRepository.findById(request.getCompany_id());
        Personnel personnel = converter.toPersonnel(request);
        personnel.setCompany(company.get());

        personnelRepository.save(personnel);

        return converter.toCreatePersonResponse(personnel);
    }


}
