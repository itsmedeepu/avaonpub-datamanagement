package com.avon.avondataimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.avon.avondatadao.adminDao;
import com.avon.avondatamanagement.dto.Admin;
import com.avon.avondatamanagement.dto.Visitor;

public class Admindaoimp implements adminDao {

	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/avon?user=root&password=root");
			return con;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveAdmin(Admin a) {

		Connection con = getConnection();
		String query = "insert into admin (username, password)" + "values(?,?)";

		try {
			PreparedStatement pt = con.prepareStatement(query);
			pt.setString(1, a.getUsername());
			pt.setString(2, a.getPassword());
			int ex = pt.executeUpdate();
			con.close();
			return ex + " inserted sucessfully";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean adminLogin(String username, String password) {

		Connection con = getConnection();
		String query = "select * from admin where username=? and password=?";

		try {
			PreparedStatement pt = con.prepareStatement(query);
			pt.setString(1, username);
			pt.setString(2, password);
			ResultSet ex = pt.executeQuery();
			boolean b = ex.next();
			con.close();
			return b;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}

}
