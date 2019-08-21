package com.vanlam.spring.service;

import java.util.List;
import java.util.Optional;

import com.vanlam.spring.entity.Company;


public interface CompanyService {
	
	List<Company> findAllCompany();
	Optional<Company> findById(Integer companyId);
	
	void save(Company company);
	void remove(Company company);
}
