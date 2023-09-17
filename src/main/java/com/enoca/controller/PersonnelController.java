package com.enoca.controller;


import com.enoca.dto.request.CreatePersonnelRequest;
import com.enoca.dto.response.CreatePersonnelResponse;
import com.enoca.service.PersonnelService;
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
}
