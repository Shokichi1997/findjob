package com.vanlam.spring.service;

import java.util.List;
import java.util.Optional;

import com.vanlam.spring.entity.Job;


public interface JobService {

	List<Job> findAllJob();
	Optional<Job> findById(Integer jobId);
	
	void save(Job job);
	void remove(Job job);
	
	List<Job> searchWithKey(String key);
}
