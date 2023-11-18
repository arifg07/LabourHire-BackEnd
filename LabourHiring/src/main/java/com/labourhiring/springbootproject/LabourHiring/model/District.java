package com.labourhiring.springbootproject.LabourHiring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class District {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String districtName;
	
	@ManyToOne
	@JoinColumn(name="state_id",nullable=false)
	private State state;
	

	@OneToMany(mappedBy="district")
	private List<Village> districtVillages;
	
	public District() {
		super();
	}
	
	public District(District createdistrict,State state) {
		this.districtName = createdistrict.getDistrictName();
		this.setState(state);
		this.setDistrictVillages(createdistrict.getDistrictVillages());
	}

	public District(Integer id, String districtName, State state, List<Village> districtVillages) {
		super();
		this.id = id;
		this.districtName = districtName;
		this.state = state;
		this.districtVillages = districtVillages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@JsonBackReference
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@JsonManagedReference
	public List<Village> getDistrictVillages() {
		return districtVillages;
	}

	public void setDistrictVillages(List<Village> districtVillages) {
		this.districtVillages = districtVillages;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", districtName=" + districtName + ", state=" + state + ", districtVillages="
				+ districtVillages + "]";
	}
	
}
