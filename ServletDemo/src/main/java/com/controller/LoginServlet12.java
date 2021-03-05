package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet12 extends GenericServlet {
	
	
	private final String USERNAME = "admin";
	private final String PASSWORD = "admin";

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		// Get the req data from ServletRequest
		res.setContentType("text/html");

		String uname = req.getParameter("username");

		String pwd = req.getParameter("password");
		

		System.out.println("UserName :" + uname + "Password : " + pwd);

		// validate the credentials
		
		if(uname.equalsIgnoreCase(USERNAME) && pwd.equalsIgnoreCase(PASSWORD)) {
			
			RequestDispatcher rd = req.getRequestDispatcher("loginSuccess.html");
			
			rd.forward(req, res);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			PrintWriter out= res.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			
			rd.include(req, res);
		}

		
	}

}
