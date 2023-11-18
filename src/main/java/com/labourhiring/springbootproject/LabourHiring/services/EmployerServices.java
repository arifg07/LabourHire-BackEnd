package com.labourhiring.springbootproject.LabourHiring.services;

import java.util.List;

import com.labourhiring.springbootproject.LabourHiring.model.Employer;
import com.labourhiring.springbootproject.LabourHiring.model.JobRequests;

public interface EmployerServices {
	
    List<Employer> get();
	
    Employer updateEmployer(Employer employer);
	
	boolean save(Employer employer);
	
	void deleteEmployer(Integer id);
	
	boolean isEmployerExistReg(String email,String phone);
	
	boolean isEmployerExistLogin(String email);

	Employer getEmployerByEmail(String email, String password);

	boolean isNumberExists(String phone);
	
	boolean saveRequest(JobRequests jobreq);

	boolean isRequestAlreadySent(Integer employerId, Integer labourId);

	List<JobRequests> isRequestApproved(Integer emp_id);
}
