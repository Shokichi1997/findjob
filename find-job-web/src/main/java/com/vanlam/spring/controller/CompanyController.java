package com.vanlam.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vanlam.spring.entity.Company;
import com.vanlam.spring.service.CompanyService;

@RestController
public class CompanyController {

	private CompanyService conpanyService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired	
	public CompanyController(CompanyService companyService) {
		this.conpanyService = companyService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/companies", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Company>> findAllResource(){
		List<Company> company = conpanyService.findAllCompany();
		if(company.isEmpty()) {
			LOGGER.info("Khong co thong tin nao duoc tim thay");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/companies/{companyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> getCompanyById(
			@PathVariable("companyId") Integer companyId){
		Optional<Company> company =  conpanyService.findById(companyId);
			
		if(!company.isPresent()) {
			LOGGER.info("Khong tim thay");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(company.get(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/companies/{companyId}", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Company> updateFood(@Valid @PathVariable("companyId") Integer companyId,
			@RequestBody Company company){
		Optional<Company> currentCompany = conpanyService.findById(companyId);
		if(!currentCompany.isPresent()) {
			return new ResponseEntity<>(currentCompany.get(), HttpStatus.NO_CONTENT);
		}

		currentCompany.get().setAddress(company.getAddress());
		currentCompany.get().setBeginTime(company.getBeginTime());
		currentCompany.get().setCompanyName(company.getCompanyName());
		currentCompany.get().setDescribe(company.getDescribe());
		currentCompany.get().setEndTime(company.getEndTime());
		currentCompany.get().setLocation(company.getLocation());
		currentCompany.get().setLogo(company.getLogo());
		currentCompany.get().setMaxEmployees(company.getMaxEmployees());
		currentCompany.get().setMinEmployees(company.getMinEmployees());
		currentCompany.get().setType(company.getType());
		
		conpanyService.save(currentCompany.get());
		LOGGER.debug("Loi o day");
		
		return new ResponseEntity<>(currentCompany.get(), HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/companies/{companyId}", method = RequestMethod.DELETE)
	public ResponseEntity<Company> deleteResource(@PathVariable("companyId") Integer companyId
			){
		Optional<Company> company = conpanyService.findById(companyId);
		if(!company.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		conpanyService.remove(company.get());
		return new ResponseEntity<>(company.get(), HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/companies", method = RequestMethod.POST)
	public ResponseEntity<Company> createResource(@Valid @RequestBody Company company, UriComponentsBuilder builder){
		conpanyService.save(company);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/company/{companyId}")
				.buildAndExpand(company.getCompanyId()).toUri());
		return new ResponseEntity<>(company, HttpStatus.CREATED);
	}
}
