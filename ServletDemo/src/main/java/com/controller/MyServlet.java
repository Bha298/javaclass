package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet {

	private ServletConfig config = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		this.config = config;
		System.out.println("servlet is initialized");

	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<b>Welcome To My First Servlet</b>");
		out.print("</body></html>");

	}

	@Override
	public String getServletInfo() {
		return "Called ServletInfo";
	}

	@Override
	public void destroy() {
		
		System.out.println("destroy hasbeen called...!");

	}

}
