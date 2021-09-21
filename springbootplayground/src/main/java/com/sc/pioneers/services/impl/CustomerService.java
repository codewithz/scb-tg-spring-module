package com.sc.pioneers.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sc.pioneers.entities.Customer;
import com.sc.pioneers.services.ICustomerService;

@Service
public class CustomerService implements ICustomerService{

	@Override
	public String addCustomer(Customer c) {
		System.out.println(c); 
		
		//Code to add it to the backend
		return "SUCCESS";
	}

	@Override
	public Customer getCustomerById(int id) {
		
		//Code to fetch from backend
		Customer c=new Customer(id,"Tom","tom@gmail.com",12345,"Savings");
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list=new ArrayList<>();
		Customer c1=new Customer(1,"Tom","tom@gmail.com",12345,"Savings");
		Customer c2=new Customer(2,"Alex","alex@gmail.com",12345,"Current");
		Customer c3=new Customer(3,"Mike","mike@gmail.com",12345,"Savings");
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		return list;
	}

	@Override
	public String updateCustomer(int id, Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
