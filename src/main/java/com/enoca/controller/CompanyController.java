package com.enoca.controller;

import com.enoca.dto.request.CreateCompanyRequest;
import com.enoca.dto.response.CreateCompanyResponse;
import com.enoca.service.CompanyService;
import com.enoca.util.GenericResponse;
import com.enoca.util.constant.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/create")
    public GenericResponse<CreateCompanyResponse> createCompany(@RequestBody CreateCompanyRequest createCompanyRequest){
        CreateCompanyResponse response = companyService.createCompany(createCompanyRequest);
        return new GenericResponse<>(
                HttpStatus.CREATED,
                HttpStatus.CREATED.value(),
                SuccessMessage.COMPANY_CREATED,
                LocalDateTime.now(),
                response
                );
    }
}
