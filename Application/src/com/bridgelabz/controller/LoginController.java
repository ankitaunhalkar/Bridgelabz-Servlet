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
		String user = request.getParameter("name");
		String password = request.getParameter("password");

		Connection con = (Connection) getServletContext().getAttribute("dbConnection");
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select name,password,email,city from users where name=? and password=?");
			ps.setString(1, user);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				User newuser = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				HttpSession session = request.getSession();
				session.setAttribute("User", newuser);
				response.sendRedirect("home.jsp");
			} else {
				pw.println("<font color='red'>No user found</font>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
