package com.github.xbynet.vo;

/**
 * @author taojiawei
 * @create 2018/1/9
 **/
public class User {
	private String email;
	private String name;
	private String password;
	public User(){

	}

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
