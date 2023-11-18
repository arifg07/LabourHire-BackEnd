package com.labourhiring.springbootproject.LabourHiring.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.*;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;

@DynamicInsert
@DynamicUpdate
@Entity
public class Labour 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String fname;

	private String lname;

	@Column(unique=true)
	private String phone;

	private String password;

	private String gender;

	private Date dateofbirth;

	private Integer stateId;

	private Integer districtId;

	private Integer villageId;

	private String place;

    private Integer postcode;
    
    private Integer hourlycharges;
    
    private Integer specializationId;
	
	@CreationTimestamp
	@Column(name="createdAt", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private Date upDatedAt;
	
	@Column(columnDefinition ="tinyint default 1")
	boolean isAvailable = true;
	
	@Column(columnDefinition = "integer default 1")
	private Integer rating;
	
	@JsonInclude
	@Transient
	private boolean approvalstatus;

	public Labour() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Labour(Integer id, String fname, String lname, String phone, String password, String gender,
			Date dateofbirth, Integer stateId, Integer districtId, Integer villageId, String place, Integer postcode,
			Integer hourlycharges, Integer specializationId, Date createdAt, Date upDatedAt, boolean isAvailable,
			Integer rating, boolean approvalstatus) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.stateId = stateId;
		this.districtId = districtId;
		this.villageId = villageId;
		this.place = place;
		this.postcode = postcode;
		this.hourlycharges = hourlycharges;
		this.specializationId = specializationId;
		this.createdAt = createdAt;
		this.upDatedAt = upDatedAt;
		this.isAvailable = isAvailable;
		this.rating = rating;
		this.approvalstatus = approvalstatus;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getVillageId() {
		return villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String area) {
		this.place = area;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcodeId(Integer postcodeId) {
		this.postcode = postcodeId;
	}


	public Integer getSpecializationId() {
		return specializationId;
	}


	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}


	public Integer getHourlycharges() {
		return hourlycharges;
	}


	public void setHourlycharges(Integer hourlycharges) {
		this.hourlycharges = hourlycharges;
	}


	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpDatedAt() {
		return upDatedAt;
	}



	public void setUpDatedAt(Date upDatedAt) {
		this.upDatedAt = upDatedAt;
	}



	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	

	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


    
	public boolean isApprovalstatus() {
		return approvalstatus;
	}

	
	public void setApprovalstatus(boolean approvalstatus) {
		this.approvalstatus = approvalstatus;
	}



	@Override
	public String toString() {
		return "Labour [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", password="
				+ password + ", gender=" + gender + ", dateofbirth=" + dateofbirth + ", stateId=" + stateId
				+ ", districtId=" + districtId + ", villageId=" + villageId + ", place=" + place + ", postcode="
				+ postcode + ", hourlycharges=" + hourlycharges + ", specializationId=" + specializationId
				+ ", createdAt=" + createdAt + ", upDatedAt=" + upDatedAt + ", isAvailable=" + isAvailable + ", rating="
				+ rating + ", approvalstatus=" + approvalstatus + "]";
	}

}
