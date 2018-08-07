package com.interview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.interview.hibernate.entity.ApplicantDetail;
import com.interview.hibernate.entity.ApplicantSkills;
import com.interview.services.ApplicantDetailService;

public class ApplicantDetailServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String tempAge = request.getParameter("age");
		int age = Integer.parseInt(tempAge);
		String collegeName = request.getParameter("college_name");
		ApplicantDetail applicantDetail = new ApplicantDetail(name, age, collegeName);

		String java = request.getParameter("java");
		String data_structures = request.getParameter("data_structures");
		String algorithm = request.getParameter("algorithm");
		String python = request.getParameter("python");
		String dot_net = request.getParameter("dot_net");
		String data_analyst = request.getParameter("data_analyst");
		String artificial_intelligence = request.getParameter("artificial_intelligence");
		ApplicantSkills applicantSkills = new ApplicantSkills(java, data_structures, algorithm, python, dot_net,
				data_analyst, artificial_intelligence);
		applicantDetail.setApplicantSkills(applicantSkills);
		String userid = (String) session.getAttribute("userid");
		ApplicantDetailService applicantDetailService = new ApplicantDetailService();
		boolean result = applicantDetailService.fillUser(applicantDetail, userid);

		if (result) {
			System.out.println("data submitted");
			request.getRequestDispatcher("/applicantFillDetail.html").forward(request, response);
		} else {
			System.out.println("data submitted");
			request.getRequestDispatcher("/applicantFillDetail.html").forward(request, response);
		}

	}
}
