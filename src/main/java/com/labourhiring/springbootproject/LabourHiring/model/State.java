package com.labourhiring.springbootproject.LabourHiring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	private String stateName;
	
	@OneToMany(mappedBy="state")
	private List<District> stateDistricts;
	
	public State() {
		// TODO Auto-generated constructor stub
	}
	
	public State(StateRequest createState) 
	{
         this.stateName = createState.getState().getStateName();
	}

	public State(Integer id, String stateName, List<District> stateDistricts) {
		super();
		this.id = id;
		this.stateName = stateName;
		this.stateDistricts = stateDistricts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@JsonManagedReference
	public List<District> getStateDistricts() {
		return stateDistricts;
	}

	public void setStateDistricts(List<District> stateDistricts) {
		this.stateDistricts = stateDistricts;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", stateName=" + stateName + ", stateDistricts=" + stateDistricts + "]";
	}
	
	
	
}
