package com.labourhiring.springbootproject.LabourHiring.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labourhiring.springbootproject.LabourHiring.dao.EmployerDAO;
import com.labourhiring.springbootproject.LabourHiring.dao.JobRequestDAO;
import com.labourhiring.springbootproject.LabourHiring.dao.LabourDAO;
import com.labourhiring.springbootproject.LabourHiring.model.Employer;
import com.labourhiring.springbootproject.LabourHiring.model.Labour;

@Service
public class LabourServicesImpl implements LabourServices 
{
	@Autowired
	LabourDAO labourDAO;
	
	@Autowired
	JobRequestDAO requestDao;
	
	@Autowired
	EmployerDAO employerDao;
	
	@Transactional 
	@Override
	public boolean saveLabour(Labour labour) {
		labourDAO.save(labour);
		return islabourExists(labour.getPhone());
	}

	@Override
	public Labour getLabourByPhoneNumber(String number, String password) {
		
		Labour lb = labourDAO.findByPhone(number);
		Labour labour = new Labour();
		labour.setId(lb.getId());
		labour.setFname(lb.getFname());
		labour.setLname(lb.getLname());
		labour.setPhone(lb.getPhone());
		labour.setGender(lb.getGender());
		labour.setDateofbirth(lb.getDateofbirth());
		labour.setStateId(lb.getStateId());
		labour.setDistrictId(lb.getDistrictId());
		labour.setVillageId(lb.getVillageId());
		labour.setPlace(lb.getPlace());
		labour.setPostcode(lb.getPostcode());
		labour.setHourlycharges(lb.getHourlycharges());
		labour.setSpecializationId(lb.getSpecializationId());
		
		if(lb != null && lb.getPassword() != null && lb.getPassword().equals(password))
		{
			return labour;
		}
		return null;
		
	}

	@Override
	public boolean islabourExists(String phone) 
	{
          Labour labour = labourDAO.findByPhoneContaining(phone);
          if(labour != null)
          {
        	  return true;
          }
          return false;
	}

	@Override
	public List<Labour> getLabourList(Integer v_id) {
		
		return labourDAO.findByVillageId(v_id);
	}

	@Override
	public List<Labour> getLabourByVillageAndSpecialization(Integer v_id,Integer spec_id) {

		return labourDAO.findByVillageIdAndSpecialization(v_id,spec_id);
	}

	@Override
	public List<Labour> getHiredList(Integer emp_id) {
		
		List<Object[]> objli = labourDAO.findHiredList(emp_id);
		List<Labour> li = new ArrayList<Labour>();
		for(Object[] ob :objli)
		{
			Labour labour = new Labour();
			labour.setDistrictId((Integer)ob[0]);
			labour.setFname((String)ob[1]);
			labour.setLname((String)ob[2]);
			labour.setGender((String)ob[3]);
			labour.setHourlycharges((Integer)ob[4]);
			labour.setPlace((String)ob[5]);
			labour.setRating((Integer)ob[6]);
			labour.setSpecializationId((Integer)ob[7]);
			labour.setStateId((Integer)ob[8]);
			labour.setVillageId((Integer)ob[9]);
			labour.setApprovalstatus((boolean)ob[10]);
			li.add(labour);
		}
		return li;
	}

	@Override
	public List<Employer> getRequestList(Integer labour_id) 
	{
		List<Object[]> obli = employerDao.getRquestList(labour_id);
		List<Employer> li = new ArrayList<>();
		for(Object[] ob:obli)
		{
			Employer emp = new Employer();
			emp.setFname((String)ob[0]);
			emp.setLname((String)ob[1]);
			emp.setVillage_id((Integer)ob[2]);
			emp.setPhone((String)ob[3]);
			emp.setPlace((String)ob[4]);
			li.add(emp);
		}
		return li;
	}
	
	

}
