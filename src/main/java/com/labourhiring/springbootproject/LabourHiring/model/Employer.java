package com.labourhiring.springbootproject.LabourHiring.model;

import java.sql.Date;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@DynamicUpdate
public class Employer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String fname;

	private String lname;

	@Column(unique=true)
	private String email;

	@Column(unique=true)
	private String phone;

	private String password;

	private String gender;

	private Date dateofbirth;

	private Integer state_id;

	private Integer district_id;

	private Integer village_id;

	private String place;

    private Integer postcode;
	
	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date upDatedAt;
	
	

	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employer(Integer id, @NotBlank String fname, @NotBlank String lname, @NotBlank @Email String email,
			@NotBlank String phone, String password, @NotBlank String gender, Date dateofbirth,
			Integer state_id, Integer district_id, Integer village_id, String place, Integer postcode, Date createdAt,
			Date upDatedAt) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.state_id = state_id;
		this.district_id = district_id;
		this.village_id = village_id;
		this.place = place;
		this.postcode = postcode;
		this.createdAt = createdAt;
		this.upDatedAt = upDatedAt;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	public Integer getState_id() {
		return state_id;
	}



	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}



	public Integer getDistrict_id() {
		return district_id;
	}



	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}



	public Integer getVillage_id() {
		return village_id;
	}



	public void setVillage_id(Integer village_id) {
		this.village_id = village_id;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public Integer getPostcode() {
		return postcode;
	}



	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
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

}
