package com.sc.pioneers.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.sc.pioneers.dao.ICustomerDAO;
import com.sc.pioneers.entities.Customer;
import com.sc.pioneers.utils.Status;

@Repository
public class CustomerDAO implements ICustomerDAO
{
	@Autowired
	JdbcTemplate template; 

	@Override
	public String addCustomer(Customer c) 
	{
		try
		{
		
		
		String query="Insert into customer(name,email,phone,acounttype) values (?,?,?,?);";
		int rowInserted=template.update(query,c.getName(),c.getEmail(),c.getPhone(),c.getAccountType());
		
		if(rowInserted==1)
		{
			return Status.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer was not created");
		}
		
		}
		catch(Exception e)
		{
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else
			{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		try {
		String query="Select id,name,email,phone,acounttype from customer";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		List<Customer> list=template.query(query,rowMapper);
		
		if(list.size()==0) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Customers found");
		}
		else
		{
			return list;
		}
		
		}
		catch (Exception e) {
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else
			{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
		
	}

	@Override
	public Customer getCustomerById(int id) {
		try {
		String query="Select id,name,email,phone,acounttype from customer where id=?;";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		Customer c=template.queryForObject(query, rowMapper,id);
		return c;
		}
		catch (DataAccessException dae) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with id ["+id+"] was not found");
		}
		catch(Exception e)
		{
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else
			{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
		
		
	
	}

	@Override
	public String updateCustomer(int id, Customer c) {
		try
		{
		
		String query="Update customer set name=?,email=?,phone=?,acounttype=? where id=?";
		int rowUpdated=template.update(query,c.getName(),c.getEmail(),c.getPhone(),c.getAccountType(),id);
		
		if(rowUpdated==1)
		{
			return Status.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with id ["+id+"] was not found");
		}
		
		}
		catch(Exception e)
		{
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else
			{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
		
	}

	@Override
	public String deleteCustomer(int id) {
		
		try {
			
	
		String query="Delete from customer where id=?";
		int rowDeleted=template.update(query,id);
		
		if(rowDeleted==1)
		{
			return Status.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with id ["+id+"] was not found");
		}
		
		}
		catch(Exception e)
		{
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else
			{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
	}

	@Override
	public List<Customer> getCustomersByAccountType(String accountType) {
		try {
		String query="Select id,name,email,phone,acounttype from customer where acounttype=?";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		List<Customer> list=template.query(query,rowMapper,accountType);
		if(list.size()==0) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Customers found");
		}
		else
		{
			return list;
		}
		
		}
		catch (Exception e) {
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else
			{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
	}
	
}
