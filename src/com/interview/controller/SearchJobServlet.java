package com.interview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.interview.hibernate.entity.CompanyDetail;
import com.interview.services.SearchJobService;

public class SearchJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CompanyDetail> list = SearchJobService.getJobs();
		if(list!=null){
			response.sendRedirect("ViewJobs.jsp"); 
			session.setAttribute("list", list); 
		}else{
			session.setAttribute("errorMessage", "no internship found"); 
		}
	}
}