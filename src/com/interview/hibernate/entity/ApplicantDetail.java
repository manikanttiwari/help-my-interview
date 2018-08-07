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
@Table(name="applicant_detail")
public class ApplicantDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "college_name")
	private String collegeName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicant_skills_id")
	private ApplicantSkills applicantSkills;
	
	public ApplicantDetail(){
		
	}
	
	public ApplicantDetail(String name, int age, String collegeName) {
		super();
		this.name = name;
		this.age = age;
		this.collegeName = collegeName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public ApplicantSkills getApplicantSkills() {
		return applicantSkills;
	}
	public void setApplicantSkills(ApplicantSkills applicantSkills) {
		this.applicantSkills = applicantSkills;
	}
	
}
