package com.bridgelabz.util;

public class User {
private String name;
private String password;
private String email;
private String city;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

@Override
public String toString() {
	return "User [name=" + name + ", password=" + password + ", email=" + email + ", city=" + city + "]";
}

}
