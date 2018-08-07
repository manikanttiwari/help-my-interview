package com.interview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.interview.hibernate.entity.AppliedApplicant;
import com.interview.services.ShowApplicantService;

public class ShowApplicantServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userid =(String ) session.getAttribute("userid");
		List<AppliedApplicant> result = ShowApplicantService.showAppliedApplicant(userid);
		
		if(result != null){
		session.setAttribute("list",result );
		response.sendRedirect("ShowAppliedApplicant.jsp");	
		}else{
			request.getRequestDispatcher("/companyDashboard.html").forward(request, response);
		}
	}

}
