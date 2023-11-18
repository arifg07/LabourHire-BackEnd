package com.labourhiring.springbootproject.LabourHiring.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labourhiring.springbootproject.LabourHiring.model.AreaOfSpecialization;
import com.labourhiring.springbootproject.LabourHiring.model.District;
import com.labourhiring.springbootproject.LabourHiring.model.State;
import com.labourhiring.springbootproject.LabourHiring.model.StateRequest;
import com.labourhiring.springbootproject.LabourHiring.model.Village;
import com.labourhiring.springbootproject.LabourHiring.dao.DistrictDAO;
import com.labourhiring.springbootproject.LabourHiring.dao.SpecializationDAO;
import com.labourhiring.springbootproject.LabourHiring.dao.StateDAO;
import com.labourhiring.springbootproject.LabourHiring.dao.VillageDAO;


@Service
public class UtilityServicesImpl implements UtilityServices {

	public UtilityServicesImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	SpecializationDAO specialization;
	
	@Autowired
	StateDAO stateDao;
	
	@Autowired
	DistrictDAO distDao;
	
	@Autowired
	VillageDAO villageDao;

	@Override
	public List<AreaOfSpecialization> getSpecilaization() {

		return specialization.findAll();
	}

	@Override
	public AreaOfSpecialization addSpecializaion(AreaOfSpecialization areaofspcl) 
	{
		return specialization.save(areaofspcl);
	}

	@Override
	public List<State> getStates() {
		
		return stateDao.findAll();
	}

	@Override
	public boolean addState(StateRequest createState) 
	{
        State state = new State(createState);
        stateDao.save(state);
        for(District dt:createState.getState().getStateDistricts())
        {
        	District dist = new District(dt,state);
        	distDao.save(dist);
        	for(Village vl:dist.getDistrictVillages())
        	{
        		Village village = new Village(vl,dist);
        		villageDao.save(village);
        	}
        }
        return true;
		
	}

	@Override
	public List<District> getDistrict(Integer id) {
		
		return distDao.findByStateId(id);
	}

	@Override
	public List<Village> getVillage(Integer id) 
	{
		return villageDao.findByDistrictId(id);
	}

}
