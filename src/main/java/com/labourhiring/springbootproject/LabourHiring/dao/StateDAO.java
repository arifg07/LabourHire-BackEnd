package com.labourhiring.springbootproject.LabourHiring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.labourhiring.springbootproject.LabourHiring.model.State;

@Repository
public interface StateDAO extends JpaRepository<State, Integer> {
	

}
