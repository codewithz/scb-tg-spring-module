package com.sc.pioneers.dao;

import com.sc.pioneers.entities.AppUser;

public interface IAppUserDAO {
	
	public AppUser getAppUser(String username);
	public boolean getLoginStatus(String username,String token);
	public void register(AppUser user);
	public void logout(String username);
	public AppUser login(String username, String token);

}
