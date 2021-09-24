package com.sc.pioneers.entities;

import java.time.LocalDate;

public class CustomerBankScheme {
	
	private int id;
	private int customerId;
	private int schemeId;
	private LocalDate date;
	private String status;
	
	
	
	
	
	public CustomerBankScheme() {
		super();
	}
	
	
	
	public CustomerBankScheme(int id, int customerId, int schemeId, LocalDate date, String status) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.schemeId = schemeId;
		this.date = date;
		this.status = status;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
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
