package com.labourhiring.springbootproject.LabourHiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.labourhiring.springbootproject.LabourHiring.model.Employer;
import com.labourhiring.springbootproject.LabourHiring.model.Labour;
import com.labourhiring.springbootproject.LabourHiring.services.LabourServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LabourController {
	
	@Autowired(required=true)
	private LabourServices labourService;
	
	
	@PostMapping(value="/labour")
	public boolean save(@RequestBody Labour labour)
	{
		return labourService.saveLabour(labour);	
	}
	
	@GetMapping("/labour/")
	public Labour labourLogin(@RequestParam String phone, @RequestParam String password)
    {
		return labourService.getLabourByPhoneNumber(phone,password);
	}
	
	@GetMapping("/validatephone")
	public boolean phoneValidation(@RequestParam String phone)
    {
		System.out.println("Inside");
		return labourService.islabourExists(phone);
	}
	
	@GetMapping("/getlabourlist/")
	public List<Labour> getLabourList(@RequestParam Integer v_id)
	{
		return labourService.getLabourList(v_id);
	}
	
	@GetMapping("/getlabourbyvillage/")
	public List<Labour> getLabourListByVillageAndSpecialization(@RequestParam Integer villageId, @RequestParam Integer specId)
	{
		return labourService.getLabourByVillageAndSpecialization(villageId,specId);
	}
	
	@GetMapping("/gethiredlist/")
	public List<Labour> getHiredList(@RequestParam Integer emp_id)
	{
		return labourService.getHiredList(emp_id);
	}
	
	@GetMapping("/getrequests/")
	public List<Employer> getRequests(@RequestParam Integer labour_id)
	{
		return labourService.getRequestList(labour_id);
	}
	
	
}
