function validation() {
var username = document.getElementById("name").value;
var email = document.getElementById("email").value;
var password = document.getElementById("password").value;
var university = document.getElementById("university").value;
if(username == "" || password == "" || email == "" || university == ""){
  alert("Fields are empty");
  return false;
}
else {
  alert("Registration Successful")
  return true;
}
}