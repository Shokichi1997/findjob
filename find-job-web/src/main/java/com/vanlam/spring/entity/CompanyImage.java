package com.vanlam.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyImage {
	
	@Id
	@Column(name = "hinh_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imageId;

	@Column(name = "hinhname")
	private String imageName;
	
	@Column(name = "com_id")
	private Integer companyId;
	
	
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	
}
