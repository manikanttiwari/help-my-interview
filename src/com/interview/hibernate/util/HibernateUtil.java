package com.interview.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static Session session = null;//com.interview.hibernate.entity.AppliedApplicant
	
	// create session factory
	public static final SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(com.interview.hibernate.entity.Applicant.class)
													.addAnnotatedClass(com.interview.hibernate.entity.ApplicantDetail.class)
													.addAnnotatedClass(com.interview.hibernate.entity.ApplicantSkills.class)
													.addAnnotatedClass(com.interview.hibernate.entity.Company.class)
													.addAnnotatedClass(com.interview.hibernate.entity.CompanyRequiredSkills.class)
													.addAnnotatedClass(com.interview.hibernate.entity.CompanyDetail.class)
													.addAnnotatedClass(com.interview.hibernate.entity.AppliedApplicant.class)
													.buildSessionFactory();
	
	public static Session getSession(){
		session = factory.getCurrentSession();
		return session;
	}
	
	

}
