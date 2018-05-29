package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.SqlOperations;

/**
 * Servlet implementation class RegisterationController
 */
public class RegistrationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String user = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		Connection con = (Connection) getServletContext().getAttribute("dbConnection");
		boolean flag = SqlOperations.registration(con,user,password,email,city);
		
			if(flag==false)
			{
				pw.println("Registration Succesfully! Now login here!");
				RequestDispatcher rd = request.getRequestDispatcher("loginpage");
				rd.include(request, response);
			}else {
				pw.println("Registration UnSuccesfully! try Again!");
				RequestDispatcher rd = request.getRequestDispatcher("registerpage");
				rd.include(request, response);
			}
		
	}

}
