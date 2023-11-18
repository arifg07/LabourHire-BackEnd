package com.labourhiring.springbootproject.LabourHiring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.labourhiring.springbootproject.LabourHiring.model.Labour;

@Repository
public interface LabourDAO extends JpaRepository<Labour, Integer>
{
	Labour findByPhone(String phone);

	Labour findByPhoneContaining(String phone);
	
	public List<Labour> findByVillageId(Integer villageId);
	
	@Query(value="select * from labour where id in (select spec.labour_id from specializationoflabour as spec where specialization_id= :spec_id) and village_id = :v_id", nativeQuery = true)
	public List<Labour> findByVillageIdAndSpecialization(Integer v_id,Integer spec_id);
	
	@Query(value="select labour.district_id,labour.fname,labour.lname,labour.gender,\r\n"
			+ "labour.hourlycharges,labour.place,labour.rating,labour.specialization_id,\r\n"
			+ "labour.state_id,labour.village_id,job_requests.approvalstatus from labour \r\n"
			+ "JOIN job_requests ON labour.id = job_requests.labour_id  and job_requests.employer_id = :emp_id", nativeQuery = true)
	public List<Object[]> findHiredList(Integer emp_id);
	
}
