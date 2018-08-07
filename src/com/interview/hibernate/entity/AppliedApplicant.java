package com.interview.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="applied_applicant")
public class AppliedApplicant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="applicant_id")
	private String applicantId;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="company_id")
	private Company company;
	
	
	public AppliedApplicant(String applicantId) {
		super();
		this.applicantId = applicantId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "AppliedApplicant [id=" + id + ", applicantId=" + applicantId + "]";
	}
	
	
	
	
}
