package com.financ.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Login {

	@JsonAlias(value = "userName")
	private String userName;

	@JsonAlias(value = "password")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
