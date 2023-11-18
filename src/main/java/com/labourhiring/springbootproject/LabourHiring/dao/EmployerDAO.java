package com.labourhiring.springbootproject.LabourHiring.dao;

import java.sql.Date;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.labourhiring.springbootproject.LabourHiring.model.Employer;
import com.labourhiring.springbootproject.LabourHiring.model.Labour;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Repository
public interface EmployerDAO extends JpaRepository<Employer, Integer>
{
    Employer findByEmail(String email);
    
    Employer findByPhone(String phone);
    
	@Query(value="select fname,lname,village_id,phone,place from employer where id in (select employer_id from job_requests where labour_id = :labour_id)", nativeQuery = true)
    List<Object[]> getRquestList(Integer labour_id);
    
     
}
