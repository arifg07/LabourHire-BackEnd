package com.labourhiring.springbootproject.LabourHiring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labourhiring.springbootproject.LabourHiring.model.AreaOfSpecialization;

@Repository
public interface SpecializationDAO extends JpaRepository<AreaOfSpecialization , Integer> 
{
	

}
