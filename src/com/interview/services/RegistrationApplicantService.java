package com.interview.services;

import org.hibernate.Session;

import com.interview.hibernate.entity.ApplicantDetail;
import com.interview.hibernate.util.HibernateUtil;

public class RegistrationApplicantService {

	public void saveCandidate(ApplicantDetail applicantDetail) {

		// get session object from HibernateUtil class
		Session session = HibernateUtil.getSession();
		try {
			// start a transaction
			session.beginTransaction();

			// save the applicant detail
			System.out.println("saving applicantDetail: " + applicantDetail);
			session.save(applicantDetail);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!...");

		} finally {
			session.close();
		}

	}

}
