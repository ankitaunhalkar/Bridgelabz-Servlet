<%@page import="com.bridgelabz.util.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<%
		User user = null;
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		
		if (session.getAttribute("User") == null) {
			response.sendRedirect("loginpage");
		} else {
			user = (User) session.getAttribute("User");
	%>
	<h3>
		Hi
		<%=user.getName()%>
	</h3>
	<h4>
		Your Email:
		<%=user.getEmail()%>
	</h4>
	<h4>
		Your City:<%=user.getCity()%>
	</h4>
		

		<a href="logout" class="btncolor" type="submit">Logout</a>

	<% } %>
</body>
</html>