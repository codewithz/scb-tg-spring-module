package com.sc.pioneers.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.sc.pioneers.entities.vo.CustomerSchemeVO;

public class CustomerSchemeVORowMapper implements RowMapper<CustomerSchemeVO>
{

	@Override
	public CustomerSchemeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		CustomerSchemeVO vo=new CustomerSchemeVO();
		vo.setCustomerName(rs.getString(1));
		vo.setAccountType(rs.getString(2));
		vo.setEmail(rs.getString(3));
		vo.setSchemeName(rs.getString(4));
		vo.setDate(LocalDate.parse(rs.getString(5)));
		vo.setStatus(rs.getString(6));
		
		return vo;
	}
	
	

}
