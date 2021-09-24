package com.sc.pioneers.services;

import java.util.List;

import com.sc.pioneers.entities.Customer;
import com.sc.pioneers.entities.vo.CustomerSchemeVO;

public interface ICustomerService 
{
	
	public String addCustomer(Customer c);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomers();
	public String updateCustomer(int id,Customer c);
	public String deleteCustomer(int id);
	public List<Customer> getCustomersByAccountType(String accountType);
	public List<CustomerSchemeVO> getSchemesForCustomer(int id);

}
