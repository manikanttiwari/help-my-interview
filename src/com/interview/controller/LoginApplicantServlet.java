package com.interview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.interview.hibernate.entity.Applicant;
import com.interview.hibernate.entity.Company;
import com.interview.services.LoginApplicantService;

public class LoginApplicantServlet extends HttpServlet {

	public void init() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		boolean result;
		if(action.equals("applicant")){
			LoginApplicantService<Applicant> loginService = new LoginApplicantService<Applicant>();
			result = loginService.authenticateUser(userid, password, action);
		}else{
			LoginApplicantService<Company> loginService = new LoginApplicantService<Company>();
			result = loginService.authenticateUser(userid, password, action);
		}
		HttpSession session=request.getSession();
		if (result){
			System.out.println("user found");
			session.setAttribute("userid", userid);
			if(action.equals("applicant"))
			   response.sendRedirect("studentDashboard.html");
			else
				response.sendRedirect("companyDashboard.html");
		}
		else
			System.out.println("user not found");

	}
}
