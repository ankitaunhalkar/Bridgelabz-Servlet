<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="javascript/validation.js"></script>
<title>Register</title>
</head>
<body>
<div class="form"> 
<form action="" method="post">

Username: <input type="text" name="name" id="name"/><br><br>
Password: <input type="text" name="pass" id="password"/><br><br>
Email: <input type="text" name="email" id="email"/><br><br>
City: <input type="text" name="city" id="city"/><br><br>
<input class="btncolor" type="submit" value="Register" onclick="return validation()"> 

</form>
</div>
</body>
</html>