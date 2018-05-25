package com.bridgelabz.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import com.bridgelabz.util.DbConnectionManager;

/**
 * Application Lifecycle Listener implementation class ConnectionListener
 *
 */

public class ConnectionListener implements ServletContextListener{

   
	public void contextInitialized(ServletContextEvent sce)  { 
      ServletContext sc = sce.getServletContext();
      
      //Db connection initialization
      String dbUrl = sc.getInitParameter("dbUrl");
      String dbUser = sc.getInitParameter("dbUser");
      String dbPassword = sc.getInitParameter("dbPassword");
      
      DbConnectionManager connectionManager = new DbConnectionManager(dbUrl, dbUser, dbPassword);
      sc.setAttribute("dbConnection", connectionManager.getConnection());
      System.out.println("DB Connection initialized.");
    }
	 
    public void contextDestroyed(ServletContextEvent sce)  { 
       Connection con = (Connection) sce.getServletContext().getAttribute("dbConnection");
       try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
    }
	
}
