package com.enoca.repository;

import com.enoca.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findByCompanyName(String CompanyName);

    Optional<Company> findByTaxId(String taxId);

    Optional<Company> findByWebSite(String webSite);
}
