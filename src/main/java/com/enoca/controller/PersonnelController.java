package com.enoca.controller;


import com.enoca.dto.request.CreatePersonnelRequest;
import com.enoca.dto.request.UpdateCompanyRequest;
import com.enoca.dto.request.UpdatePersonnelRequest;
import com.enoca.dto.response.*;
import com.enoca.service.PersonnelService;
import com.enoca.util.GenericResponse;
import com.enoca.util.constant.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/personnel")
@RequiredArgsConstructor
public class PersonnelController {

    private final PersonnelService personnelService;
    @PostMapping("/create")
    public GenericResponse<CreatePersonnelResponse> createCompany(@RequestBody CreatePersonnelRequest request){
        CreatePersonnelResponse response = personnelService.savePerson(request);
        return new GenericResponse<>(
                HttpStatus.CREATED,
                HttpStatus.CREATED.value(),
                SuccessMessage.PERSON_CREATED,
                LocalDateTime.now(),
                response
        );
    }
    @PutMapping("/updateById/{id}")
    public GenericResponse<?> updateById(@PathVariable Long id, @RequestBody UpdatePersonnelRequest request) throws InvocationTargetException, IllegalAccessException {
        UpdatePersonnelResponse updatePersonnelResponse = personnelService.updateById(id, request);
        return new GenericResponse<>(
                HttpStatus.OK,
                HttpStatus.OK.value(),
                SuccessMessage.UPDATED_PERSONNEL,
                LocalDateTime.now(),
                updatePersonnelResponse
        );
    }
    @GetMapping("/getAll/{id}")
    public GenericResponse<?> getAllPerson(@PathVariable Long id){
        List<GetAllPersonnelResponse> allCompany = personnelService.getAllPersonnel(id);
        return new GenericResponse<>(
                HttpStatus.OK,
                HttpStatus.OK.value(),
                SuccessMessage.GET_ALL_PERSON,
                LocalDateTime.now(),
                allCompany
        );
    }
}
