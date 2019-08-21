package com.vanlam.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vanlam.spring.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>{
	
	@Query("from Job where jobname like CONCAT('%',:searchkey,'%')")
	 List<Job> searchJobByKeySearch(@Param("searchkey") String searchkey);
}
