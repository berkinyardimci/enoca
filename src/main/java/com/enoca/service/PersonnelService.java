package com.enoca.service;

import com.enoca.repository.PersonnelRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    public PersonnelService(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

}
