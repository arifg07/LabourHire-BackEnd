package com.labourhiring.springbootproject.LabourHiring.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labourhiring.springbootproject.LabourHiring.model.Village;

@Repository
public interface VillageDAO extends JpaRepository<Village, Integer> {

	List<Village> findByDistrictId(Integer id);
}
