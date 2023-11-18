package com.labourhiring.springbootproject.LabourHiring.services;

import java.util.List;

import com.labourhiring.springbootproject.LabourHiring.model.Employer;
import com.labourhiring.springbootproject.LabourHiring.model.Labour;

public interface LabourServices 
{
	boolean saveLabour(Labour labour);
	
	Labour getLabourByPhoneNumber(String number,String password);
	
	boolean islabourExists(String phone);

	List<Labour> getLabourList(Integer v_id);
	
	List<Labour> getLabourByVillageAndSpecialization(Integer v_id,Integer spec_id);
	
	List<Labour> getHiredList(Integer emp_id);
	
	List<Employer> getRequestList(Integer labour_id);
}
