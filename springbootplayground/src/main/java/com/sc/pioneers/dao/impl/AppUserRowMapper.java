package com.sc.pioneers.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sc.pioneers.entities.AppUser;

public class AppUserRowMapper implements RowMapper<AppUser> 
{

	@Override
	public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
	    AppUser user = new AppUser();
        user.setId(rs.getInt("id"));
        user.setDisplayName(rs.getString("display_name"));
        user.setUsername(rs.getString("username"));
        user.setToken(rs.getString("token"));
        user.setPasswordHash(rs.getString("password_hash"));
        user.setRoles(rs.getString("roles"));

        return user;
	}
	

}
