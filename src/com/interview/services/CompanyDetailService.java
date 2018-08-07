package com.interview.services;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.interview.hibernate.entity.Applicant;
import com.interview.hibernate.entity.Company;
import com.interview.hibernate.entity.CompanyDetail;
import com.interview.hibernate.util.HibernateUtil;

public class CompanyDetailService {

	public boolean fillCompanyDetail(CompanyDetail companyDetail, String userid) {
		
		// get session object from HibernateUtil class
		Session session = HibernateUtil.getSession();
		try { 
			// start a transaction
			session.beginTransaction();

			String hql = "FROM Company a WHERE a.userid =:userid";
			@SuppressWarnings("unchecked")
			Query<Company> query = session.createQuery(hql);
			query.setString("userid", userid);
			Company company = (Company)query.uniqueResult();
			System.out.println(company);
			company.setCompanyDetail(companyDetail);
			 
			// saving the object
			int i = (int) session.save(company);
			
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
