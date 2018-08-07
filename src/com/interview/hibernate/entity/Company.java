package com.interview.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "userid")
	private String userid;

	@Column(name = "password")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_detail_id")
	private CompanyDetail companyDetail;
	 
	@OneToMany(fetch = FetchType.EAGER, mappedBy="company",
			   cascade=CascadeType.ALL)
	private List<AppliedApplicant> appliedApplicants;
	
	public Company(){
		
	}
		
	public Company(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CompanyDetail getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(CompanyDetail companyDetail) {
		this.companyDetail = companyDetail;
	}
	
	public List<AppliedApplicant> getAppliedApplicants() {
		return appliedApplicants;
	}


	public void setAppliedApplicants(List<AppliedApplicant> appliedApplicants) {
		this.appliedApplicants = appliedApplicants;
	}
	
	// add convenience methods for bi-directional relationship
	
	public void add(AppliedApplicant tempAppliedApplicant) {
		
		if (appliedApplicants == null) {
			appliedApplicants = new ArrayList<>();
		}
		
		appliedApplicants.add(tempAppliedApplicant);
		
		tempAppliedApplicant.setCompany(this);
	}
	
}
