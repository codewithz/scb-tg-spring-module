package com.sc.pioneers.services;

import com.sc.pioneers.entities.vo.AppUserLoginVO;
import com.sc.pioneers.entities.vo.AppUserRegisterVO;
import com.sc.pioneers.entities.vo.AppUserTokenVO;

public interface IAuthService {

	
	public AppUserTokenVO login(AppUserLoginVO loginVO);
	public void logout(AppUserTokenVO tokenVO);
	public void createAppUser(AppUserRegisterVO userVO);
	public boolean authenticate(AppUserTokenVO tokenVO);
	public boolean authorize(AppUserTokenVO tokenVO,String role);
	
	
	
}
