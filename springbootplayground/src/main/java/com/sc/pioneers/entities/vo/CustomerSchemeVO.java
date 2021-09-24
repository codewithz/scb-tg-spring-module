package com.sc.pioneers.entities.vo;

import java.time.LocalDate;

public class CustomerSchemeVO 
{
	
	private String customerName;
	private String accountType;
	private String email;
	private String schemeName;
	private LocalDate date;
	private String status;
	
	public CustomerSchemeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerSchemeVO(String customerName, String accountType, String email, String schemeName, LocalDate date,
			String status) {
		super();
		this.customerName = customerName;
		this.accountType = accountType;
		this.email = email;
		this.schemeName = schemeName;
		this.date = date;
		this.status = status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
