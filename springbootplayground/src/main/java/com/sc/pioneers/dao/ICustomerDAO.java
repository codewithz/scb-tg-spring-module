package com.sc.pioneers.dao;

import java.util.List;

import com.sc.pioneers.entities.Customer;

public interface ICustomerDAO {
	
	public String addCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public String updateCustomer(int id,Customer c);
	public String deleteCustomer(int id);
	public List<Customer> getCustomersByAccountType(String accountType);

}
