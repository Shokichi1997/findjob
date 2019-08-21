package com.vanlam.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "company")
public class Company {
	
	@Id
	@Column(name = "com_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	
	@Column(name = "comname")
	private String companyName;
	
	@Column(name = "comlogo")
	private String logo;
	
	@Column(name = "comdecribe")
	private String describe;
	
	@Column(name = "comtype")
	private Integer type;
	
	@Column(name = "comlocation")
	private String location;
	
	@Column(name = "combegintime")
	private Integer beginTime;
	
	@Column(name = "comendtime")
	private Integer endTime;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "minemployee")
	private Integer minEmployees;
	
	@Column(name = "maxemmployee")
	private Integer maxEmployees;
	
	@JsonIgnoreProperties(value = {"company"})
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<Job> jobs = new ArrayList<>();
	
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMinEmployees() {
		return minEmployees;
	}
	public void setMinEmployees(Integer minEmployees) {
		this.minEmployees = minEmployees;
	}
	public Integer getMaxEmployees() {
		return maxEmployees;
	}
	public void setMaxEmployees(Integer maxEmployees) {
		this.maxEmployees = maxEmployees;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	
	
}
