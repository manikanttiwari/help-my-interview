package com.interview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.interview.hibernate.entity.CompanyDetail;
import com.interview.hibernate.entity.CompanyRequiredSkills;
import com.interview.services.CompanyDetailService;

public class CompanyDetailServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String name = request.getParameter("name");
		String company_age = request.getParameter("company_tenure");
		int company_tenure = Integer.parseInt(company_age);
		String jobName = request.getParameter("job_name");
		CompanyDetail companyDetail = new CompanyDetail(name, company_tenure, jobName);
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		String skill1 = request.getParameter("java");
		String skill2 = request.getParameter("data_strctures");
		String skill3 = request.getParameter("algorithm");
		String skill4 = request.getParameter("python");
		String skill5 = request.getParameter("dot_net");
		String skill6 = request.getParameter("data_analyst");
		String skill7 = request.getParameter("artificial_intelligence");
		CompanyRequiredSkills applicantSkills = new CompanyRequiredSkills(skill1, skill2, skill3, skill4, skill5,
				skill6, skill7);

		companyDetail.setCompanyRequiredSkills(applicantSkills);

		CompanyDetailService registrationCompanyService = new CompanyDetailService();
		boolean result = registrationCompanyService.fillCompanyDetail(companyDetail, userid);

		if (result) {
			System.out.println("data submitted");
			request.setAttribute("errorMessage", "data has been submitted");
			 request.getRequestDispatcher("/companyFillDetail.html").forward(request, response);
			//System.out.println("company detail filled");
			
		} else {
			request.setAttribute("errorMessage", "data has not been submitted");
			 request.getRequestDispatcher("/companyFillDetail.html").forward(request, response);
		}

	}
}
