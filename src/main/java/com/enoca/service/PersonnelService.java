package com.enoca.service;

import com.enoca.dto.request.CreatePersonnelRequest;
import com.enoca.dto.request.UpdatePersonnelRequest;
import com.enoca.dto.response.CreatePersonnelResponse;
import com.enoca.dto.response.GetAllCompanyResponse;
import com.enoca.dto.response.GetAllPersonnelResponse;
import com.enoca.dto.response.UpdatePersonnelResponse;
import com.enoca.entity.Company;
import com.enoca.entity.Personnel;
import com.enoca.repository.CompanyRepository;
import com.enoca.repository.PersonnelRepository;
import com.enoca.util.converter.Converter;
import com.enoca.util.exception.CompanyNotFoundException;
import com.enoca.util.exception.PersonnelNotFoundException;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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
        Company existingCompany = companyRepository.findById(request.getCompany_id()).orElseThrow(() -> new CompanyNotFoundException(request.getCompany_id()));
        Personnel personnel = converter.toPersonnel(request);
        personnel.setCompany(existingCompany);

        personnelRepository.save(personnel);

        return converter.toCreatePersonResponse(personnel);
    }
    public UpdatePersonnelResponse updateById(Long id, UpdatePersonnelRequest request) throws InvocationTargetException, IllegalAccessException {
        Personnel existingPersonnel = personnelRepository.findById(id).orElseThrow(() -> new PersonnelNotFoundException(id));
        Optional<Company> company = companyRepository.findById(request.getCompany_id());
        existingPersonnel.setCompany(company.get());

        BeanUtils.copyProperties(existingPersonnel, request);
        personnelRepository.save(existingPersonnel);
        return converter.toUpdatePersonnelResponse(existingPersonnel);
    }

    public List<GetAllPersonnelResponse> getAllPersonnel(Long companyId){

        List<Personnel> allByCompanyId = personnelRepository.findAllByCompanyId(companyId);
        List<GetAllPersonnelResponse> list = new ArrayList<>();
        allByCompanyId.forEach(item -> list.add(converter.toGetAllPersonnelResponse(item)));
        return list;
    }
}
