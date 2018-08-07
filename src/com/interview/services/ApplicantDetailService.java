package com.interview.services;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.interview.hibernate.entity.Applicant;
import com.interview.hibernate.entity.ApplicantDetail;
import com.interview.hibernate.util.HibernateUtil;

public class ApplicantDetailService {

	@SuppressWarnings("deprecation")
	public boolean fillUser(ApplicantDetail applicantDetail, String userid) {
		Session session = HibernateUtil.getSession();
		try {
			// start a transaction
			session.beginTransaction();
			
			String hql = "FROM Applicant a WHERE a.userid =:userid";
			@SuppressWarnings("unchecked")
			Query<Applicant> query = session.createQuery(hql);
			query.setString("userid", userid);
			Applicant applicant = (Applicant)query.uniqueResult();
			applicant.setApplicantDetail(applicantDetail);
			
			// saving the object
			int i = (int) session.save(applicant);
			
			if(i == 0){
				//commit the transaction
				session.getTransaction().commit();
				return false;
			}
			else{
				//commit the transaction
				session.getTransaction().commit();
				return true;
			}
			
						

		} finally {
			session.close();
		}

	}

}
