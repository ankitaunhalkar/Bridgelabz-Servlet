function validateRegister() {
	
var emailPattern=/(^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$)/;
var passwordPattern=/^[a-z]+$/;
var usernamePattern=/^[a-z]+$/;
var cityPattern=/^[a-z]+$/;

var username = document.getElementById("name").value;
var email = document.getElementById("email").value;
var password = document.getElementById("password").value;
var city = document.getElementById("city").value;
if(username == "" || password == "" || email == "" || city == ""){
  alert("Fields are empty");
  return false;
}
else {
  alert("Registration Successful")
  return true;
}
}

function validateLogin() {
var username = document.getElementById("name").value;
var password = document.getElementById("password").value;
if(username == "" || password == ""){
  alert("Fields are empty");
  return false;
}
else {
  alert("Login Successful")
  return true;
}
}