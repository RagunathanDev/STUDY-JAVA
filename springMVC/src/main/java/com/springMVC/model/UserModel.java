package com.springMVC.model;

public class UserModel {

	private String name;
	private String password;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserModel [name=" + name + ", password=" + password + "]";
	}

}
