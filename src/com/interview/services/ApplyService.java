package com.interview.services;

import java.util.List;

import org.hibernate.Session;

import com.interview.hibernate.entity.AppliedApplicant;
import com.interview.hibernate.entity.Company;
import com.interview.hibernate.util.HibernateUtil;

import javassist.bytecode.Descriptor.Iterator;

public class ApplyService {

	public static boolean applyForJob(String id, String userid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theid = Integer.parseInt(id);
			Company tempCompany = session.get(Company.class, theid );
			System.out.println(tempCompany);
			
			AppliedApplicant appliedApplicant = new AppliedApplicant(userid);
			
			List<AppliedApplicant> appliedApplicants = tempCompany.getAppliedApplicants();
			
			appliedApplicants.add(appliedApplicant);
			
			tempCompany.setAppliedApplicants(appliedApplicants);
			java.util.Iterator<AppliedApplicant> itr = tempCompany.getAppliedApplicants().iterator();
			while(itr.hasNext()){
				System.out.println("heyyyyyyyyyyyyyyy "+itr.next());
			}
			System.out.println("haaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			
			// save the courses 
			int id1 = (int)session.save(tempCompany);
			if(id1 == 0){
			  // commit transaction
			  session.getTransaction().commit();
			  return false;
			}else{
				System.out.println("saved............");
				// commit transaction
				session.getTransaction().commit();
				return true;
			}
		}
		finally {
			
			// add clean up code
			session.close();
		}
	}
	
	
}
