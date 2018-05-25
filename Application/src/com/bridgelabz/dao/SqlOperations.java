package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.util.User;

public class SqlOperations {
	public static User checkLogin(Connection con, String email, String password) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		User newuser = null;
		
		try {
			
			ps = con.prepareStatement("select name,password,email,city from users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if (rs != null && rs.next()) {
				
				newuser = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
			} else {
				
				System.out.println("Login Failed!");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				rs.close();
				ps.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return newuser;
	}

	public static boolean registration(Connection con, String user, String password, String email, String city) {
		PreparedStatement ps = null;
		boolean flag = true;
		try {
			
			ps = con.prepareStatement("insert into users(name,password,email,city) values(?,?,?,?)");
			ps.setString(1, user);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, city);
			flag = ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				ps.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		return flag;
	}

}
