package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.SqlOperations;
import com.bridgelabz.util.DbConnectionManager;
import com.bridgelabz.util.User;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Connection con = (Connection) getServletContext().getAttribute("dbConnection");
		User newuser = SqlOperations.checkLogin(con,email,password);
		if(newuser!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("User", newuser);
			response.sendRedirect("home.jsp");
		}
		else {
			pw.println("<font color='red'>No user found</font>");
		}

	}

}
