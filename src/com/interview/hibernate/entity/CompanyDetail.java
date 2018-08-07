package com.interview.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="company_detail")
public class CompanyDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cname")
	private String cname;
	
	@Column(name = "company_tenure")
	private int companyTenure;
	
	@Column(name = "jobs")
	private String jobs;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_required_skills_id")
	private CompanyRequiredSkills companyRequiredSkills;
	
	public CompanyDetail(){
		
	}
	
	public CompanyDetail(String companyName, int company_tenure, String jobs) {
		super();
		this.cname = companyName;
		this.companyTenure = company_tenure;
		this.jobs = jobs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return cname;
	}

	public void setCompanyName(String companyName) {
		this.cname = companyName;
	}


	
	public int getCompanyTenure() {
		return companyTenure;
	}

	public void setCompanyTenure(int companyTenure) {
		this.companyTenure = companyTenure;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public CompanyRequiredSkills getCompanyRequiredSkills() {
		return companyRequiredSkills;
	}

	public void setCompanyRequiredSkills(CompanyRequiredSkills companyRequiredSkills) {
		this.companyRequiredSkills = companyRequiredSkills;
	}
	
	
}
