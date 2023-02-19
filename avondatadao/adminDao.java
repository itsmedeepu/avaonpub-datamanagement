package com.avon.avondatadao;

import java.sql.Connection;

import com.avon.avondatamanagement.dto.Admin;

public interface adminDao {
	
	public Connection getConnection();

	public String saveAdmin(Admin a);

	public boolean adminLogin(String username, String password);

}