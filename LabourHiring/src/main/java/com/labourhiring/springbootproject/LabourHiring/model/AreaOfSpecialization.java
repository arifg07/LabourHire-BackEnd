package com.labourhiring.springbootproject.LabourHiring.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="areaofpecialization")
public class AreaOfSpecialization 
{
	@Id
	private Integer id;
	
	private String specialization;
	
	
	public AreaOfSpecialization() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AreaOfSpecialization(int id, String specialization) {
		super();
		this.id = id;
		this.specialization = specialization;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	@Override
	public String toString() {
		return "AreaOfSpecialization [id=" + id + ", specialization=" + specialization + "]";
	}	
	
	
	
	
}
