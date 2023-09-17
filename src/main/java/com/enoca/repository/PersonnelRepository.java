package com.enoca.repository;

import com.enoca.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel,Long> {


    List<Personnel> findAllByCompanyId(Long companyId);

}
