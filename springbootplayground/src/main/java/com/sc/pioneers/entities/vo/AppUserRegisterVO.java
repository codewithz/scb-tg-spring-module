package com.sc.pioneers.entities.vo;

public class AppUserRegisterVO {
	
	private String username;
	private String password;
	private String displayName;
	private String[] roles;
	
	
	
	
	public AppUserRegisterVO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public AppUserRegisterVO(String username, String password, String displayName, String[] roles) {
		super();
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.roles = roles;
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




	public String getDisplayName() {
		return displayName;
	}




	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}




	public String[] getRoles() {
		return roles;
	}




	public void setRoles(String[] roles) {
		this.roles = roles;
	};
	
	
	
	
	
	

}
