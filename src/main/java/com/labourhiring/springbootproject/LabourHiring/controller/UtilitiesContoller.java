package com.labourhiring.springbootproject.LabourHiring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labourhiring.springbootproject.LabourHiring.model.AreaOfSpecialization;
import com.labourhiring.springbootproject.LabourHiring.model.District;
import com.labourhiring.springbootproject.LabourHiring.model.State;
import com.labourhiring.springbootproject.LabourHiring.model.StateRequest;
import com.labourhiring.springbootproject.LabourHiring.model.Village;
import com.labourhiring.springbootproject.LabourHiring.services.UtilityServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UtilitiesContoller {

	@Autowired(required = true)
	private UtilityServices utilityService;

	@PostMapping(value="/addspecialization")
	public AreaOfSpecialization addSpecialization(@RequestBody AreaOfSpecialization specialization)
	{
		return utilityService.addSpecializaion(specialization);
	} 
	
	@GetMapping("/getspecialization")
	public List<AreaOfSpecialization> getSpecilaization()
    {
		return utilityService.getSpecilaization();
	}
	
	//State api
	@PostMapping(value="/savestate")
	public boolean saveState(@RequestBody StateRequest state)
	{
		return utilityService.addState(state);
	} 
	
	@GetMapping("/getstates")
	public List<State> getStates()
    {
		return utilityService.getStates();
	}
	
	
	@GetMapping("/getdistrict/{id}")
	public List<District> getDistrict(@PathVariable Integer id)
    {
		return utilityService.getDistrict(id);
	}
	
	@GetMapping("/getvillage/{id}")
	public List<Village> getVillage(@PathVariable Integer id)
    {
		return utilityService.getVillage(id);
	}
	
	
	
	
}
