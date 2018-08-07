package com.interview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interview.hibernate.entity.Applicant;
import com.interview.hibernate.entity.Company;
import com.interview.services.SignUpService;

public class SignUpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String action = request.getParameter("action");

		Applicant applicant = new Applicant(userid, password);

		Company company = new Company(userid, password);
		boolean result;
		if (action.equals("applicant")) {
			SignUpService<Applicant> signUpApplicantService = new SignUpService<Applicant>();
			result = signUpApplicantService.signUpApplicant(applicant, action);
		} else {
			SignUpService<Company> signUpService = new SignUpService<Company>();
			result = signUpService.signUpApplicant(company, action);
		}
		if (result) {
			response.sendRedirect("login.html");
			System.out.println("user is saved into the data base");
		} else {
			request.getRequestDispatcher("/signUp.html").forward(request, response);
			System.out.println("user is not saved into the data bese");

		}
	}
}
