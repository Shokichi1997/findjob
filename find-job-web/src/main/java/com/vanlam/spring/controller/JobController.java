package com.vanlam.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

import com.vanlam.spring.entity.Job;
import com.vanlam.spring.repository.JobRepository;
import com.vanlam.spring.service.JobService;


@RestController
public class JobController {
	
	private JobService jobService;
	private static final Logger LOGGER = LoggerFactory.getLogger(JobController.class);
	
	@Autowired	
	public JobController(JobService resourceService) {
		this.jobService = resourceService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/jobs", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Job>> findAllJob(){
		List<Job> jobs = jobService.findAllJob();
		if(jobs.isEmpty()) {
			LOGGER.info("Khong co thong tin nao duoc tim thay");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Job> getJobById(
			@PathVariable("jobId") Integer jobId){
		Optional<Job> job =  jobService.findById(jobId);
			
		if(!job.isPresent()) {
			LOGGER.info("Khong tim thay");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(job.get(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Job> updateJob(@Valid @PathVariable("resourceId") Integer jobId,
			@RequestBody Job job){
		Optional<Job> currentJob = jobService.findById(jobId);
		if(!currentJob.isPresent()) {
			return new ResponseEntity<>(currentJob.get(), HttpStatus.NO_CONTENT);
		}

		currentJob.get().setJobName(job.getJobName());
		currentJob.get().setBenefit(job.getBenefit());
		currentJob.get().setJobDescribe(job.getJobDescribe());
		currentJob.get().setJobSkill(job.getJobSkill());
		currentJob.get().setMinSalary(job.getMinSalary());
		currentJob.get().setMaxSalary(job.getMaxSalary());
		currentJob.get().setReason(job.getReason());
		currentJob.get().setCompany(job.getCompany());
		
		jobService.save(currentJob.get());
		return new ResponseEntity<>(currentJob.get(), HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.DELETE)
	public ResponseEntity<Job> deleteJob(@PathVariable("jobId") Integer jobId
			){
		Optional<Job> job = jobService.findById(jobId);
		if(!job.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		jobService.remove(job.get());
		return new ResponseEntity<>(job.get(), HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/jobs", method = RequestMethod.POST)
	public ResponseEntity<Job> createJob(@Valid @RequestBody Job job, UriComponentsBuilder builder){
		jobService.save(job);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/jobs/{jobId}")
				.buildAndExpand(job.getJobId()).toUri());
		return new ResponseEntity<>(job, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	 @RequestMapping(value = "/search/{searchKey}", method = RequestMethod.GET)
	 public ResponseEntity<List<Job>> searchJobByKeySearch(@PathVariable("searchKey") String searchKey){
		 List<Job> jobs = jobService.searchWithKey(searchKey);
		 if(jobs.isEmpty()) {
			 return new ResponseEntity<>(jobs,HttpStatus.NO_CONTENT);
		 }
		 
		return new ResponseEntity<> (jobs, HttpStatus.OK);
	 }

}
