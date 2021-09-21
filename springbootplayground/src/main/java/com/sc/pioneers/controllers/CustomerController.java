package com.sc.pioneers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sc.pioneers.entities.Customer;
import com.sc.pioneers.services.ICustomerService;

@RestController
public class CustomerController {
	
	//ICustomerService customerService=new CustomerService();
	
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/customer")
	public String addCustomer(@RequestBody Customer c)
	{
		String result=customerService.addCustomer(c);
		return result;
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable int id)
	{
		Customer c=customerService.getCustomerById(id);
		return c;
	}
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers()
	{
		List<Customer> list=customerService.getAllCustomers();
		return list;
	}
	
	@PutMapping("/customer/{id}")
	public String updateCustomer(@PathVariable int id,Customer c)
	{
		return null;
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		return null;
	}
}
