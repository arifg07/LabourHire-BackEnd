package com.labourhiring.springbootproject.LabourHiring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.labourhiring.springbootproject.LabourHiring.model.JobRequests;
import com.labourhiring.springbootproject.LabourHiring.model.Labour;

public interface JobRequestDAO extends JpaRepository<JobRequests, Integer> 
{
	
	@Query("FROM JobRequests WHERE employerId = :employerId AND labourId = :labourId")
	JobRequests findByLabourId(Integer employerId, Integer labourId);
	
	 public List<JobRequests> findByEmployerId(Integer emp_id);

}
