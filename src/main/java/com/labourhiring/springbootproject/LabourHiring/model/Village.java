package com.labourhiring.springbootproject.LabourHiring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Village {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String villageName;
	
	@ManyToOne
	@JoinColumn(name="district_id",nullable=false)
	private District district;
	
	public Village() {
		// TODO Auto-generated constructor stub
	}

	public Village(Integer id, String villageName, District district) {
		super();
		this.id = id;
		this.villageName = villageName;
		this.district = district;
	}

	public Village(Village vl,District district) 
	{
         this.villageName = vl.getVillageName();
         this.setDistrict(district);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	@JsonIgnore
	@JsonBackReference
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Village [id=" + id + ", villageName=" + villageName + ", district=" + district + "]";
	}
	
	

}
