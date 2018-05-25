package com.bridgelabz.util;

public class User {
private int id;
private String name;
private String password;
private String email;
private String city;

public User(String name, String password, String email, String city) {
	super();
	this.name = name;
	this.password = password;
	this.email = email;
	this.city = city;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
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
