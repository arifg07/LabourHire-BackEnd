package com.labourhiring.springbootproject.LabourHiring.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labourhiring.springbootproject.LabourHiring.dao.EmployerDAO;
import com.labourhiring.springbootproject.LabourHiring.dao.JobRequestDAO;
import com.labourhiring.springbootproject.LabourHiring.model.Employer;
import com.labourhiring.springbootproject.LabourHiring.model.JobRequests;
import com.labourhiring.springbootproject.LabourHiring.model.Labour;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Service
public  class EmployerServiceImpl implements EmployerServices {

	@Autowired
	EmployerDAO eRepository;
	
	@Autowired
	JobRequestDAO requestDao;
	
	@Transactional 
	@Override
	public List<Employer> get() {
         
		return eRepository.findAll();

	}
	
	@Transactional 
	@Override
	public boolean save(Employer employer) {

		Employer emp = eRepository.save(employer);
		return isEmployerExistLogin(emp.getEmail());
		
	}

	@Transactional 
	@Override
	public void deleteEmployer(Integer id) 
	{
		eRepository.deleteById(id);	
	}


	@Override
	public boolean isEmployerExistReg(String email, String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmployerExistLogin(String email) 
	{
       Employer emp = eRepository.findByEmail(email);

       if(emp != null)
       {
    	   return true;
       }
       return false;
	}

	@Override
	public Employer getEmployerByEmail(String email, String password) {
		
		Employer emp = eRepository.findByEmail(email);
		if(emp == null)	
		{
			return null;
		}
		Employer employer = new Employer(emp.getId(),emp.getFname(), emp.getLname(), emp.getEmail(),
				emp.getPhone(),"",emp.getGender(), emp.getDateofbirth(),
				emp.getState_id(), emp.getDistrict_id(), emp.getVillage_id(),
				emp.getPlace(), emp.getPostcode(), emp.getCreatedAt(),
				emp.getUpDatedAt());
		if(emp != null && emp.getPassword() != null && emp.getPassword().equals(password))
		{
            return employer;
		}
		return null;
	}

	@Override
	public boolean isNumberExists(String phone) 
	{
         Employer employer = eRepository.findByPhone(phone);
         if(employer != null)
         {
        	 return true;
         }
         return false;
	}

	@Override
	public Employer updateEmployer(Employer employer) {
		Optional<Employer> emp = eRepository.findById(employer.getId());
		
		Employer updateEmployer;
		updateEmployer = emp.get();
		if(!emp.isPresent())
		{
			return null;
		}
		updateEmployer.setId(employer.getId());
		updateEmployer.setFname(employer.getFname());
		updateEmployer.setLname(employer.getLname());
		updateEmployer.setGender(employer.getGender());
		updateEmployer.setDateofbirth(employer.getDateofbirth());
		updateEmployer.setState_id((Integer)(employer.getState_id()));
		updateEmployer.setDistrict_id((Integer)(employer.getDistrict_id()));
		updateEmployer.setVillage_id((Integer)(employer.getVillage_id()));
		updateEmployer.setPlace(employer.getPlace());
		updateEmployer.setPostcode(employer.getPostcode());	
		eRepository.save(updateEmployer);
		return getEmployerByEmail(updateEmployer.getEmail(), updateEmployer.getPassword());
	}

	@Override
	public boolean saveRequest(JobRequests jobreq) 
	{
		requestDao.save(jobreq);
		return true;
	}

	@Override
	public boolean isRequestAlreadySent(Integer employerId, Integer labourId) 
	{
		JobRequests req =  requestDao.findByLabourId(employerId, labourId);
		if(req!=null)
		System.err.println(req.getEmployerId());
		if(req!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<JobRequests> isRequestApproved(Integer emp_id) {
		System.out.println("hello");
		return requestDao.findByEmployerId(emp_id);
	}
	
	

}
