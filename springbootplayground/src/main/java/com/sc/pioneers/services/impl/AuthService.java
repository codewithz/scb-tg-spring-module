package com.sc.pioneers.services.impl;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.google.common.hash.Hashing;
import com.sc.pioneers.dao.IAppUserDAO;
import com.sc.pioneers.entities.AppUser;
import com.sc.pioneers.entities.vo.AppUserLoginVO;
import com.sc.pioneers.entities.vo.AppUserRegisterVO;
import com.sc.pioneers.entities.vo.AppUserTokenVO;
import com.sc.pioneers.services.IAuthService;

@Service
public class AuthService implements IAuthService{
	
	@Autowired
	IAppUserDAO userDAO;

	@Override
	public AppUserTokenVO login(AppUserLoginVO loginVO) {
		
		AppUser userDb=userDAO.getAppUser(loginVO.getUsername());
		String hashedPassword=Hashing.sha512().hashString(loginVO.getPassword(), StandardCharsets.UTF_8).toString();
		
		if(userDb.getPasswordHash().equals(hashedPassword))
		{
			String token=UUID.randomUUID().toString();
			AppUser loggedInUser=userDAO.login(loginVO.getUsername(), token);
			
			AppUserTokenVO tokenVO=new AppUserTokenVO();
			tokenVO.setDisplayName(loggedInUser.getDisplayName());
			tokenVO.setRoles(loggedInUser.getRoles());
			tokenVO.setUsername(loggedInUser.getUsername());
			tokenVO.setToken(loggedInUser.getToken());
			
			return tokenVO;
			
		}
		else
		{
			userDAO.logout(loginVO.getUsername());
			System.out.println("Test");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login Failed");
		}
		
	
		
		
		
		
		
	}

	@Override
	public void logout(AppUserTokenVO tokenVO) {
		
		userDAO.logout(tokenVO.getUsername());
		
	}

	@Override
	public void createAppUser(AppUserRegisterVO userVO) {

		AppUser user=new AppUser();
		String roles=Arrays.stream(userVO.getRoles()).collect(Collectors.joining(";"));
		String hashedPassword=Hashing.sha512().hashString(userVO.getPassword(), StandardCharsets.UTF_8).toString();
		
		user.setRoles(roles);
		user.setPasswordHash(hashedPassword);
		user.setDisplayName(userVO.getDisplayName());
		user.setUsername(userVO.getUsername());
		
		userDAO.register(user);
		
	}

	@Override
	public boolean authenticate(AppUserTokenVO tokenVO) {
		if (userDAO.getLoginStatus(tokenVO.getUsername(), tokenVO.getToken())) {
			return true;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED User");
		}
	}

	@Override
	public boolean authorize(AppUserTokenVO tokenVO, String role) {
			if(!authenticate(tokenVO)) {
				return false;
			}
			
			AppUser userDb=userDAO.getAppUser(tokenVO.getUsername());
			
			return Arrays.stream(userDb.getRoles().split(";")).anyMatch(r->r.equals(role));
	}
	
	
	

}
