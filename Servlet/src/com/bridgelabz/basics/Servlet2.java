package com.bridgelabz.basics;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
/*config and context example*/
public class Servlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletConfig sc = getServletConfig();
		String name=sc.getInitParameter("name");
		out.print(name);
		
		ServletContext scon = getServletContext();
		String company = scon.getInitParameter("company");
		out.println(company);
	}

	

}