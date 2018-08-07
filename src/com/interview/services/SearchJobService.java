package com.interview.services;

import java.util.List;
import org.hibernate.query.Query;

import org.hibernate.Session;

import com.interview.hibernate.entity.CompanyDetail;
import com.interview.hibernate.util.HibernateUtil;

public class SearchJobService {

	public static List<CompanyDetail> getJobs() {
		// get session object from HibernateUtil class
		Session session = HibernateUtil.getSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			Query<CompanyDetail> query = session.createQuery("FROM CompanyDetail");
			query.setMaxResults(2);
			List<CompanyDetail> results = query.list();
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!...");
			return results;
		} finally {
			session.close();
		}

	}

}
