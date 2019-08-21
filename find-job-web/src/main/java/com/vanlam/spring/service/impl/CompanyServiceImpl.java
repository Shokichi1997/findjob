package com.vanlam.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanlam.spring.entity.Company;
import com.vanlam.spring.repository.CompanyRepository;
import com.vanlam.spring.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository companyRepository;
	
	@Autowired
	public CompanyServiceImpl (CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	@Override
	public List<Company> findAllCompany() {
		return companyRepository.findAll();
	}

	@Override
	public Optional<Company> findById(Integer companyId) {
		return companyRepository.findById(companyId);
	}

	@Override
	public void save(Company company) {
		companyRepository.save(company);
	}

	@Override
	public void remove(Company company) {
		companyRepository.delete(company);
	}

}
