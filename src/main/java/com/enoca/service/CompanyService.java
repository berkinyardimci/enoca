package com.enoca.service;

import com.enoca.dto.request.CreateCompanyRequest;
import com.enoca.dto.request.UpdateCompanyRequest;
import com.enoca.dto.response.CreateCompanyResponse;
import com.enoca.dto.response.GetAllCompanyResponse;
import com.enoca.dto.response.UpdateCompanyResponse;
import com.enoca.entity.Company;
import com.enoca.repository.CompanyRepository;
import com.enoca.util.GenericResponse;
import com.enoca.util.converter.Converter;
import com.enoca.util.exception.CompanyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService{

    private final CompanyRepository companyRepository;
    private final Converter converter;



    public CreateCompanyResponse createCompany(CreateCompanyRequest createCompanyRequest) {
        Company company = converter.toCompany(createCompanyRequest);
        companyRepository.save(company);
        return converter.toCreateCompanyResponse(company);
    }

    public List<GetAllCompanyResponse> getAllCompany(){
        List<GetAllCompanyResponse> list = new ArrayList<>();
        companyRepository.findAll().forEach(company ->
            list.add(converter.toGetAllCompanyResponse(company)));
        return list;
    }

    public void deleteById(Long id){
        companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
        companyRepository.deleteById(id);
    }

    public UpdateCompanyResponse updateById(Long id, UpdateCompanyRequest request) throws InvocationTargetException, IllegalAccessException {
        Company existingCompany = companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
        BeanUtils.copyProperties(existingCompany, request);
        companyRepository.save(existingCompany);
        return converter.toUpdateCompanyResponse(existingCompany);
    }
}
