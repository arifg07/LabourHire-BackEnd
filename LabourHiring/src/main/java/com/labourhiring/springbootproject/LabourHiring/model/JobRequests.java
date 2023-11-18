package com.labourhiring.springbootproject.LabourHiring.model;


import jakarta.persistence.*;

@Entity
public class JobRequests {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer employerId;
	private Integer labourId;
	private boolean approvalstatus = false;

	public JobRequests() {
		
	}

	public JobRequests(Integer id, Integer employerId, Integer labourId,boolean approvalstatus) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.labourId = labourId;
		this.approvalstatus = approvalstatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	public Integer getLabourId() {
		return labourId;
	}

	public void setLabourId(Integer labourId) {
		this.labourId = labourId;
	}

	public boolean isApprovalstatus() {
		return approvalstatus;
	}

	public void setApprovalstatus(boolean approvalstatus) {
		this.approvalstatus = approvalstatus;
	}

	@Override
	public String toString() {
		return "JobRequests [id=" + id + ", employerId=" + employerId + ", labourId=" + labourId + ", approvalstatus="
				+ approvalstatus + "]";
	}
    
}
