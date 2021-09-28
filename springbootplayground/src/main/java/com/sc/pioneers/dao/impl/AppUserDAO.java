package com.sc.pioneers.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sc.pioneers.dao.IAppUserDAO;
import com.sc.pioneers.entities.AppUser;

@Repository
public class AppUserDAO implements IAppUserDAO {
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public AppUser getAppUser(String username) {
		
		String query="Select id,username,display_name,password_hash,token,roles from appusers where username=?";
		RowMapper<AppUser> rowMapper=new AppUserRowMapper();
		AppUser user=template.queryForObject(query,rowMapper,username);
		return user;
		
		
	}

	@Override
	public boolean getLoginStatus(String username, String token) {
		String query="Select count(id) from appusers where username=? and token=?";
		int result=template.queryForObject(query,new Object[] {username,token},Integer.class);
		
		return result>0;
	}

	@Override
	public void register(AppUser user) {
		String query="Insert into appusers(username,display_name,password_hash,roles) values (?,?,?,?)";
		template.update(query,user.getUsername(),user.getDisplayName(),user.getPasswordHash(),user.getRoles());
		
	}

	@Override
	public void logout(String username) {
		
		String query="Update appusers set token='' where username=?";
		template.update(query,username);
		
	}

	@Override
	public AppUser login(String username, String token) {
		String query="Update appusers set token=? where username=?";
		template.update(query,token,username);
		return getAppUser(username);
		
		
	}

}
