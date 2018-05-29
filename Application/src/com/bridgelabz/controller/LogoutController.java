package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */

public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 *  HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		Cookie cookies[] = request.getCookies();
//		if(cookies!=null)
//		{
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equals("JSESSIONID"))
//				{
//					System.out.println(cookie.getValue());
//					break;
//				}
//			}
//		}
		
		//invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	if(session != null){
    		session.removeAttribute("User");
       		session.invalidate();
    		response.sendRedirect("loginpage");
    		}
    	}

}
