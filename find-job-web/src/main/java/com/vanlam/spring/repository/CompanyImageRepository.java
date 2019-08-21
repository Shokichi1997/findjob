package com.vanlam.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanlam.spring.entity.CompanyImage;

@Repository
public interface CompanyImageRepository extends JpaRepository<CompanyImage, Integer>{

}
