package com.sc.pioneers.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sc.pioneers.dao.ICustomerSchemeVODAO;
import com.sc.pioneers.entities.vo.CustomerSchemeVO;

@Repository
public class CustomerSchemeDAO implements ICustomerSchemeVODAO
{
	@Autowired
	JdbcTemplate template;

	@Override
	public List<CustomerSchemeVO> getSchemesByCustomerId(int customerId) {
		
		String query="Select c.name,c.email,c.acounttype,s.name,cs.date,cs.status\r\n" + 
				"from customer c \r\n" + 
				"join customer_scheme cs \r\n" + 
				"on c.id=cs.customer_id\r\n" + 
				"JOIN bank_scheme s on s.id=cs.bank_scheme_id\r\n"+
				"where c.id="+customerId+";";
		
		RowMapper<CustomerSchemeVO> rowMapper=new CustomerSchemeVORowMapper();
		List<CustomerSchemeVO> list=template.query(query, rowMapper);
		return list;
		
	}
	
	

}
