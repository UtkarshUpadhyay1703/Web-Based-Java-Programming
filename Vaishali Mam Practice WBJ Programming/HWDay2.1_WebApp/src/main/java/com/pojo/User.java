package com.pojo;

public class User {
	private String user_name;
	private String email;
	private String password;
	private String city;

	public User(String user_name, String email, String password, String city) {
		super();
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", email=" + email + ", password=" + password + ", city=" + city + "]";
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
