package com.enoca.repository;

import com.enoca.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel,Long> {
}
