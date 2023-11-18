package com.labourhiring.springbootproject.LabourHiring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labourhiring.springbootproject.LabourHiring.model.District;

@Repository
public interface DistrictDAO extends JpaRepository<District, Integer> 
{

	List<District> findByStateId(Integer id);

}
