package com.labourhiring.springbootproject.LabourHiring.model;

import jakarta.persistence.*;

@Entity
public class Reviews {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer labour_id;
	private Integer employer_id;
	private String employerName;
	private String review;
	
	public Reviews() {

	}
	
	public Reviews(Integer id, Integer labour_id, Integer employer_id, String review,String employerName) {
		super();
		this.id = id;
		this.labour_id = labour_id;
		this.employer_id = employer_id;
		this.review = review;
		this.employerName = employerName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLabour_id() {
		return labour_id;
	}

	public void setLabour_id(Integer labour_id) {
		this.labour_id = labour_id;
	}

	public Integer getEmployer_id() {
		return employer_id;
	}

	public void setEmployer_id(Integer employer_id) {
		this.employer_id = employer_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	
	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", labour_id=" + labour_id + ", employer_id=" + employer_id + ", employerName="
				+ employerName + ", review=" + review + "]";
	}


	

}
