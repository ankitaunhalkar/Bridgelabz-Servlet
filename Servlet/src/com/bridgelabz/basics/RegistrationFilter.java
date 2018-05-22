package com.bridgelabz.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegistrationFilter implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Name:<input type="text" name="name">
		// Email:<input type="text" name="email">
		// Password:<input type="text" name="password">
		// University:<input type="text" name="university">
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String university = request.getParameter("university");

		if ((!name.equals("")) && (!email.equals(""))
				&& (!password.equals("")) && (!university.equals(""))) {

			chain.doFilter(request, response);// sends request to next resource
		} else {
			out.println("Please enter all the fields");

			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			
		}
		out.close();
	}

}
