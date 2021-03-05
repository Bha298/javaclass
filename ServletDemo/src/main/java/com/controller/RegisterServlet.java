package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private final String USERNAME = "admin";
	private final String PASSWORD = "admin";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		this.service(req, res);

	}

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// Get the req data from ServletRequest
		res.setContentType("text/html");

		String uname = req.getParameter("username");

		String pwd = req.getParameter("password");
		
		String mobile = req.getParameter("mobile");

		String dob = req.getParameter("date");
		

		System.out.println("UserName :" + uname + "Password : " + pwd );
		System.out.println("Mobile :"+ mobile + "DOB :"+dob);

		// validate the credentials

		if (uname.equalsIgnoreCase(USERNAME) && pwd.equalsIgnoreCase(PASSWORD)) {

			/*
			 * RequestDispatcher rd = req.getRequestDispatcher("loginSuccess.html");
			 * 
			 * rd.forward(req, res);
			 */
			res.sendRedirect("loginSuccess.html");
			
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			PrintWriter out = res.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");

			rd.include(req, res);
		}

	}

}
