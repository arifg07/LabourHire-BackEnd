package com.labourhiring.springbootproject.LabourHiring.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.labourhiring.springbootproject.LabourHiring.model.Employer;
import com.labourhiring.springbootproject.LabourHiring.model.JobRequests;
import com.labourhiring.springbootproject.LabourHiring.services.EmployerServices;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployerController 
{
	@Autowired
	private EmployerServices employerService;
	
	
	@PostMapping(value="/employer")
	public boolean saveEmployer(@Valid @RequestBody Employer empobj) 
	{
		return employerService.save(empobj);	
	}
	
	@DeleteMapping("/employer/{id}")
	public void deleteEmployer(@PathVariable Integer id)
	{
		employerService.deleteEmployer(id);
	}
	
	@GetMapping("employer/validatenumber/")
	public boolean getEmployerByPhone(@RequestParam String phone)
	{
		return employerService.isNumberExists(phone);
	}
	
	@GetMapping("employer/isalreadyexist/")
	public boolean getEmployerByEmail(@RequestParam String email)
	{
		return employerService.isEmployerExistLogin(email);
	}
	
	@GetMapping("/employer/login/")
	public Employer employerLogin(@RequestParam String email, @RequestParam String password)
    {
		return employerService.getEmployerByEmail(email,password);
	}
	
	@PostMapping(value="/updateemployer")
	public Employer update(@Valid @RequestBody Employer empobj) 
	{
		return employerService.updateEmployer(empobj);	
	}
	
	@PostMapping(value="/saverequest")
	public boolean saveRequest(@RequestBody JobRequests jobreq) 
	{
		return employerService.saveRequest(jobreq);	
	}
		
	@GetMapping("/isreqalrdysent/")
	public boolean isRequestSent(@RequestParam Integer employerId,@RequestParam Integer labourId)
	{
		return employerService.isRequestAlreadySent(employerId,labourId);
	}
	
	@GetMapping("/requestlist/")
	public List<JobRequests> isRequestApproved(@RequestParam Integer emp_id)
	{
		return employerService.isRequestApproved(emp_id);
	}

}
