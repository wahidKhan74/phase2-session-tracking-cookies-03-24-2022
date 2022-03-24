package com.simplilearn.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logout() {
	}

	// cookie based logout
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// add navigation
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);

		// cookie based logout
		Cookie ck1 = new Cookie("useremail", "");
		ck1.setMaxAge(0);
		Cookie ck2 = new Cookie("password", "");
		ck2.setMaxAge(0);
		
		response.addCookie(ck1);
		response.addCookie(ck2);
		out.println("<h3 style='color:green'>Sucessfull logout </h3>");
	}

	// submit logout page
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
