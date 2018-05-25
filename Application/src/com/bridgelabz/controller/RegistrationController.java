package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PreparedStatement ps = null;
		
		try {
			ps=con.prepareStatement("insert into users(name,password,email,city) values(?,?,?,?)");
			ps.setString(1, user);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, city);
			boolean flag = ps.execute();
			if(flag==false)
			{
				pw.println("Registration Succesfully! Now login here!");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}else {
				pw.println("Registration UnSuccesfully! try Again!");
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
