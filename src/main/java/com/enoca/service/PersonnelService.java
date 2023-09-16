package com.enoca.service;

import com.enoca.entity.Personnel;
import com.enoca.repository.PersonnelRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonnelService extends ServiceManager<Personnel,Long>{

    private final PersonnelRepository personnelRepository;
    public PersonnelService(PersonnelRepository personnelRepository) {
        super(personnelRepository);
        this.personnelRepository = personnelRepository;
    }

}
