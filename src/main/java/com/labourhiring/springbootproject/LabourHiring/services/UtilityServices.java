package com.labourhiring.springbootproject.LabourHiring.services;


import com.labourhiring.springbootproject.LabourHiring.model.AreaOfSpecialization;
import com.labourhiring.springbootproject.LabourHiring.model.District;
import com.labourhiring.springbootproject.LabourHiring.model.State;
import com.labourhiring.springbootproject.LabourHiring.model.StateRequest;
import com.labourhiring.springbootproject.LabourHiring.model.Village;

import java.util.*;


public interface UtilityServices {

	//Area of Specialization
	List<AreaOfSpecialization> getSpecilaization();
	
	AreaOfSpecialization addSpecializaion(AreaOfSpecialization areaofspcl);
	
	
	//State List
	List<State> getStates();
	
	//Add new State
	boolean addState(StateRequest state);
	
	//District List
	List<District> getDistrict(Integer id);

	List<Village> getVillage(Integer id);
	
	
	

}
