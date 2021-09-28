package com.sc.pioneers.entities.vo;

public class AppUserTokenVO {
	
	private String username;
	private String displayName;
	private String roles;
	private String token;
	
	public AppUserTokenVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUserTokenVO(String username, String displayName, String roles, String token) {
		super();
		this.username = username;
		this.displayName = displayName;
		this.roles = roles;
		this.token = token;
	}
	
	

	public AppUserTokenVO(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
	

}
