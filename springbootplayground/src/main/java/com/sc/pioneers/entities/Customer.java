package com.sc.pioneers.entities;

public class Customer {
	
	private int id;
	private String name;
	private String email;
	private long phone;
	private String accountType;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int id, String name, String email, long phone, String accountType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.accountType = accountType;
	}


	public Customer(String name, String email, long phone, String accountType) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.accountType = accountType;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", accountType="
				+ accountType + "]";
	}


	
	
	
	
	
	
	
	
	
	

}
