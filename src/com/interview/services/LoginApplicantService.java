package com.interview.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.interview.hibernate.entity.Applicant;
import com.interview.hibernate.util.HibernateUtil;

public class LoginApplicantService<T> {

	public boolean authenticateUser(String userid, String password, String action) {

		Session session = HibernateUtil.getSession();
 
		try {
			// start a transaction
			session.beginTransaction();
			String hql;
			if(action.equals("applicant"))
				hql = "FROM Applicant a WHERE a.userid =:userid and a.password=:password";
			else{
				hql = "FROM Company a WHERE a.userid =:userid and a.password=:password";
			}
			Query<Applicant> query = session.createQuery(hql);
			query.setString("userid", userid);
			query.setString("password", password);
			T applicant = (T)query.uniqueResult();
			if (applicant == null) {
				// commit transaction
				session.getTransaction().commit();
				System.out.println("user not found");
				return false;
			} else {
				
				session.getTransaction().commit();
				return true;
			}

		} finally {
			session.close();
		}

	}

}
