package com.sc.pioneers.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
		
		
		String query="Insert into customer(name,email,phone,acounttype) values (?,?,?,?);";
		int rowInserted=template.update(query,c.getName(),c.getEmail(),c.getPhone(),c.getAccountType());
		
		if(rowInserted==1)
		{
			return Status.SUCCESS;
		}
		else
		{
			return Status.NOT_FOUND;
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		String query="Select id,name,email,phone,acounttype from customer";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		List<Customer> list=template.query(query,rowMapper);
		return list;
	}

	@Override
	public Customer getCustomerById(int id) {
		
		String query="Select id,name,email,phone,acounttype from customer where id=?;";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		Customer c=template.queryForObject(query, rowMapper,id);
		return c;
	}

	@Override
	public String updateCustomer(int id, Customer c) {
		
		String query="Update customer set name=?,email=?,phone=?,acounttype=? where id=?";
		int rowUpdated=template.update(query,c.getName(),c.getEmail(),c.getPhone(),c.getAccountType(),id);
		
		if(rowUpdated==1)
		{
			return Status.SUCCESS;
		}
		else
		{
			return Status.NOT_FOUND;
		}
		
	}

	@Override
	public String deleteCustomer(int id) {
		String query="Delete from customer where id=?";
		int rowDeleted=template.update(query,id);
		
		if(rowDeleted==1)
		{
			return Status.SUCCESS;
		}
		else
		{
			return Status.NOT_FOUND;
		}
	}

	@Override
	public List<Customer> getCustomersByAccountType(String accountType) {
		String query="Select id,name,email,phone,acounttype from customer where acounttype=?";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		List<Customer> list=template.query(query,rowMapper,accountType);
		return list;
	}
	
}
