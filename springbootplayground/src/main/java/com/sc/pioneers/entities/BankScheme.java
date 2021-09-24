package com.sc.pioneers.entities;

public class BankScheme 
{
	
	private int id;
	private String name;
	
	public BankScheme() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "BankScheme [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
