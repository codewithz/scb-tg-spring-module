package com.sc.pioneers.dao;

import java.util.List;

import com.sc.pioneers.entities.vo.CustomerSchemeVO;

public interface ICustomerSchemeVODAO {
	
	
	public List<CustomerSchemeVO> getSchemesByCustomerId(int customerId);

}
