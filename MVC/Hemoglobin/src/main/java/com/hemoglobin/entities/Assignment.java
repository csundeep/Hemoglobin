package com.hemoglobin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignments")
@NamedQueries({ @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a ") })
public class Assignment {

	@Id
	@GeneratedValue
	@Column(name = "assignment_id")
	private int assignmentId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "donor_id")
	private Donor donor;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "request_id")
	private BloodRequest bloodRequest;

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public BloodRequest getBloodRequest() {
		return bloodRequest;
	}

	public void setBloodRequest(BloodRequest bloodRequest) {
		this.bloodRequest = bloodRequest;
	}

	@Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", donor=" + donor + ", bloodRequest=" + bloodRequest + "]";
	}

}
