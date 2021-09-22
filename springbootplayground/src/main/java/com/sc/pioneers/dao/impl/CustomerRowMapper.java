package com.sc.pioneers.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sc.pioneers.entities.Customer;

public class CustomerRowMapper implements RowMapper<Customer>
{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Customer c=new Customer();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setPhone(rs.getLong("phone"));
		c.setAccountType(rs.getString("acounttype"));
		
		return c;
	}

}
