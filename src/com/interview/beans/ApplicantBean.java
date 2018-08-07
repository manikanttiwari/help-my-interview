package com.interview.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.interview.hibernate.entity.ApplicantDetail;

public class ApplicantBean {
	
	private int id;

	private String userid;

	private String password;

	private ApplicantDetail applicantDetail;

	public ApplicantBean(int id, String userid, String password) {
		super();
		this.id = id;
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

	public ApplicantDetail getApplicantDetail() {
		return applicantDetail;
	}

	public void setApplicantDetail(ApplicantDetail applicantDetail) {
		this.applicantDetail = applicantDetail;
	}

}
