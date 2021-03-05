package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String USERNAME = "admin";
	private final String PASSWORD = "admin";

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");

		// Get the clinet credentials

		String uname = req.getParameter("username");

		String pwd = req.getParameter("password");

		System.out.println("UserName :" + uname + "Password : " + pwd);

		if (uname.equalsIgnoreCase(USERNAME) && pwd.equalsIgnoreCase(PASSWORD)) {
			
			// Create the Session and add the user information
			
			HttpSession session = req.getSession();
			session.setAttribute("uname", uname);
			// set the time for session in the server
			session.setMaxInactiveInterval(1*60);

			// add the client credentails to cookie

			Cookie loginCookie = new Cookie("uname", uname);
			// set the time for cookie
			loginCookie.setMaxAge(1 * 60);
			// add the cookie to res object
			res.addCookie(loginCookie);

			res.sendRedirect("jsp/loginSuccess.jsp");

		} else {
			RequestDispatcher rd = req.getRequestDispatcher("jsp/login.jsp");
			PrintWriter out = res.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");

			rd.include(req, res);
		}

	}

}
