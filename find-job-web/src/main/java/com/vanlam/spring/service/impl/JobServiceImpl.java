package com.vanlam.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vanlam.spring.entity.Job;
import com.vanlam.spring.repository.JobRepository;
import com.vanlam.spring.service.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	private JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAllJob() {
		return jobRepository.findAll();
	}

	@Override
	public Optional<Job> findById(Integer jobId) {
		return jobRepository.findById(jobId);
	}

	@Override
	public void save(Job job) {
		jobRepository.save(job);
		
	}

	@Override
	public void remove(Job job) {
		jobRepository.delete(job);
		
	}
	
	@Override
	public List<Job> searchWithKey(String key) {
		return jobRepository.searchJobByKeySearch(key);
	}

}
