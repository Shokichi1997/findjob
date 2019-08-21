package com.vanlam.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanlam.spring.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
}
