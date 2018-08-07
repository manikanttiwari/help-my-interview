package com.interview.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.interview.hibernate.entity.AppliedApplicant;
import com.interview.hibernate.entity.Company;
import com.interview.hibernate.entity.CompanyDetail;
import com.interview.hibernate.util.HibernateUtil;

public class ShowApplicantService {

	public static List<AppliedApplicant> showAppliedApplicant(String userid) {
		
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
					System.out.println("dataaadddddddddddddddddjnkd");
					List<AppliedApplicant> appliedApplicants = company.getAppliedApplicants();
					java.util.Iterator<AppliedApplicant> itr = appliedApplicants.iterator();
					while(itr.hasNext()){
						System.out.println("heyyyyyyyyyyyyyyy "+itr.next());
					}
					return appliedApplicants;

				} finally {
					session.close();
				}
	}

}
