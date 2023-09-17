package com.enoca.controller;

import com.enoca.dto.request.CreateCompanyRequest;
import com.enoca.dto.request.UpdateCompanyRequest;
import com.enoca.dto.response.CreateCompanyResponse;
import com.enoca.dto.response.GetAllCompanyResponse;
import com.enoca.dto.response.UpdateCompanyResponse;
import com.enoca.service.CompanyService;
import com.enoca.util.GenericResponse;
import com.enoca.util.constant.SuccessMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/getAll")
    public GenericResponse<?> getAllCompany(){
        List<GetAllCompanyResponse> allCompany = companyService.getAllCompany();
        return new GenericResponse<>(
                HttpStatus.OK,
                HttpStatus.OK.value(),
                SuccessMessage.GET_ALL_COMPANIES,
                LocalDateTime.now(),
                !allCompany.isEmpty() ? allCompany : "Şirket Eklenmedi"
        );
    }

    @DeleteMapping("/deleteById/{id}")
    public GenericResponse<?> deleteById(@PathVariable Long id){
        companyService.deleteById(id);
        return new GenericResponse<>(
                HttpStatus.OK,
                HttpStatus.OK.value(),
                SuccessMessage.DELETED_COMPANY,
                LocalDateTime.now()
        );
    }
    @PutMapping("/updateById/{id}")
    public GenericResponse<?> updateById(@PathVariable Long id, @RequestBody UpdateCompanyRequest request) throws InvocationTargetException, IllegalAccessException {
        UpdateCompanyResponse updateCompanyResponse = companyService.updateById(id, request);
        return new GenericResponse<>(
                HttpStatus.OK,
                HttpStatus.OK.value(),
                SuccessMessage.UPDATED_COMPANY,
                LocalDateTime.now(),
                updateCompanyResponse
        );
    }
}
