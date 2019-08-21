package com.vanlam.spring.service;

import java.util.List;
import java.util.Optional;

import com.vanlam.spring.entity.CompanyImage;

public interface CompanyImageService {
	List<CompanyImage> findAllImages();
	Optional<CompanyImage> findById(Integer imageId);
	
	void save(CompanyImage companyImage);
	void remove(CompanyImage companyImage);
}
