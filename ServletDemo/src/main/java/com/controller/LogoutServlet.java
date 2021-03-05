package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String USERNAME = "admin";
	private final String PASSWORD = "admin";

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");

		Cookie loginCookie = null;

		// Get the cookie from browser

		Cookie[] cookieArr = req.getCookies();

		if (cookieArr != null) {
			for (Cookie cookie : cookieArr) {
				if (cookie != null && cookie.getName().equalsIgnoreCase("uname")) {
					loginCookie = cookie;
					break;

				}
			}
		}

		if (loginCookie != null) {
			loginCookie.setMaxAge(0);
			res.addCookie(loginCookie);
		}
		res.sendRedirect("jsp/login.jsp");
	}

}
