package com.interview.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applicant_skills")
public class ApplicantSkills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "skill1")
	private String skill1;
	
	@Column(name = "skill2")
	private String skill2;
	
	@Column(name = "skill3")
	private String skill3;
	
	@Column(name = "skill4")
	private String skill4;
	
	@Column(name = "skill5")
	private String skill5;
	
	@Column(name = "skill6")
	private String skill6;
	
	@Column(name = "skill7")
	private String skill7;
	
	public ApplicantSkills(){
		
	}
	
	public ApplicantSkills(String skill1, String skill2, String skill3, String skill4, String skill5,
			String skill6, String skill7) {
		super();
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.skill4 = skill4;
		this.skill5 = skill5;
		this.skill6 = skill6;
		this.skill7 = skill7;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkill1() {
		return skill1;
	}
	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}
	public String getSkill2() {
		return skill2;
	}
	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
	public String getSkill3() {
		return skill3;
	}
	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}
	public String getSkill4() {
		return skill4;
	}
	public void setSkill4(String skill4) {
		this.skill4 = skill4;
	}
	public String getSkill5() {
		return skill5;
	}
	public void setSkill5(String skill5) {
		this.skill5 = skill5;
	}
	public String getSkill6() {
		return skill6;
	}
	public void setSkill6(String skill6) {
		this.skill6 = skill6;
	}
	public String getSkill7() {
		return skill7;
	}
	public void setSkill7(String skill7) {
		this.skill7 = skill7;
	}
		
}
