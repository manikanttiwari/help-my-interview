package com.interview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.interview.services.ApplyService;


public class ApplyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("requsest");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		String id = request.getParameter("apply");
		System.out.println("woooooooooooooooooooooooooooooooow "+id);
		boolean result = ApplyService.applyForJob(id, userid);
		
		if(result){
			System.out.println("applied in the company");
//			response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
//		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
//		    response.getWriter().write("Applied");       // Write response body.
		}
	}

}
