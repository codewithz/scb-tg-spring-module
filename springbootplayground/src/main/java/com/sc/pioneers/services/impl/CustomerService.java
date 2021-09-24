package com.sc.pioneers.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.pioneers.dao.ICustomerDAO;
import com.sc.pioneers.dao.ICustomerSchemeVODAO;
import com.sc.pioneers.entities.Customer;
import com.sc.pioneers.entities.vo.CustomerSchemeVO;
import com.sc.pioneers.services.ICustomerService;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private ICustomerSchemeVODAO csDAO;
	

	@Override
	public String addCustomer(Customer c) {
		
		String result=customerDAO.addCustomer(c);
		return result;
	}

	@Override
	public Customer getCustomerById(int id) {
		
		Customer c=customerDAO.getCustomerById(id);
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list=customerDAO.getAllCustomers();
		return list;
	}

	@Override
	public String updateCustomer(int id, Customer c) {
		String result=customerDAO.updateCustomer(id, c);
		return result;
	}

	@Override
	public String deleteCustomer(int id) {
		String result=customerDAO.deleteCustomer(id);
		return result;
	}

	@Override
	public List<Customer> getCustomersByAccountType(String accountType) {
		List<Customer> list=customerDAO.getCustomersByAccountType(accountType);
		return list;
	}

	@Override
	public List<CustomerSchemeVO> getSchemesForCustomer(int id) {
		List<CustomerSchemeVO> list=csDAO.getSchemesByCustomerId(id);
		return list;
	}

}
