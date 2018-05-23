package com.bridgelabz.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
//		HttpSession session = request.getSession();
//		String user = request.getParameter("name");
//		session.setAttribute("key", user);
		PrintWriter out = response.getWriter();
		out.println("Welcome to home page");
	}
}
