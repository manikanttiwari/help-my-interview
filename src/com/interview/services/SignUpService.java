package com.interview.services;

import org.hibernate.Session;

import com.interview.hibernate.entity.Applicant;
import com.interview.hibernate.util.HibernateUtil;

public class SignUpService<T> {

	public boolean signUpApplicant(T applicant, String action) {
		// get session object from HibernateUtil class
		Session session = HibernateUtil.getSession();
		try {

			// start a transaction
			session.beginTransaction();

			// save the applicant
			System.out.println("saving user: " + applicant);
			int id = (Integer) session.save(applicant);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!...");

			if (id == 0) {

				return false;

			} else {

				return true;

			}

		}

		finally {

			session.close();

		}

	}

}
