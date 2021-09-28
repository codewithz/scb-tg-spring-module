package com.sc.pioneers.entities.vo;

public class AppUserLoginVO {
	
	private String username;
	private String password;
	
	
	public AppUserLoginVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AppUserLoginVO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
