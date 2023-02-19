package com.avon.avondataimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.avon.avondatadao.vistorDao;
import com.avon.avondatamanagement.dto.Visitor;

public class Visitordaoimp implements vistorDao {

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
	public Visitor saveVisitor(Visitor vistor) {

		Connection con = getConnection();

		Visitor m1 = getVisitorbyContactno(vistor.getContactno());
		Visitor m2 = getVisitorbyemail(vistor.getEmail());
		Visitor m3 = getVisitorbyidproofNumber(vistor.getIdProofNumber());
		
		
		//for testing purpose
//		System.out.println(m1);
//		System.out.println(m2);
//		System.out.println(m3);
    //check user already exist and update accordingly 
		if (vistor.getContactno().equals(m1.getContactno()) && vistor.getEmail().equals(m2.getEmail())
				&& vistor.getIdProofNumber().equals(m3.getIdProofNumber())) {
			if (m1.getId() == m2.getId() && m3.getId() == m2.getId()) {
				vistor.setId(m1.getId());

			}
			Visitor up = updateVisitor(vistor);

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return up;

		}

		else {
			String query = "insert into visitor (name, email, contact_no, age, gender, vtime, vdate, idprooftype, address, idproofnumber)"
					+ "values(?,?,?,?,?,?,?,?,?,?)";

			try {
				PreparedStatement pt = con.prepareStatement(query);
				pt.setString(1, vistor.getName());
				pt.setString(2, vistor.getEmail());
				pt.setString(3, vistor.getContactno());
				pt.setInt(4, vistor.getAge());
				pt.setString(5, vistor.getGender());
				pt.setString(6, vistor.getVisitingtime());
				pt.setString(7, vistor.getVisitingDate());
				pt.setString(8, vistor.getIdProofType());
				pt.setString(9, vistor.getAddress());
				pt.setString(10, vistor.getIdProofNumber());

				int ex = pt.executeUpdate();

				Visitor vt = getVisitorbyContactno(vistor.getContactno());

				con.close();
				return vt;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public Visitor updateVisitor(Visitor vistor) {
		Connection con = getConnection();

		try {

			String query = "update visitor set name=?, email=?, contact_no=?, age=?, gender=?, vtime=?, vdate=?, idprooftype=?, address=?, idproofnumber=? where id=?";
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, vistor.getName());
			pt.setString(2, vistor.getEmail());
			pt.setString(3, vistor.getContactno());
			pt.setInt(4, vistor.getAge());
			pt.setString(5, vistor.getGender());
			pt.setString(6, vistor.getVisitingtime());
			pt.setString(7, vistor.getVisitingDate());

			pt.setString(8, vistor.getIdProofType());
			pt.setString(9, vistor.getAddress());
			pt.setString(10, vistor.getIdProofNumber());
			pt.setInt(11, vistor.getId());

			// update visitor
			int ex = pt.executeUpdate();
			Visitor v = getVisitorbyId(vistor.getId());

			con.close();
			return v;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Visitor> getallVisitors() {
		Connection con = getConnection();
		List<Visitor> lv = new ArrayList<Visitor>();

		try {

			String query = "select * from visitor ";
			PreparedStatement pt = con.prepareStatement(query);
			ResultSet ex = pt.executeQuery();

			while (ex.next()) {
				Visitor vz = new Visitor();
				vz.setId(ex.getInt(1));
				vz.setName(ex.getString(2));
				vz.setEmail(ex.getString(3));
				vz.setContactno(ex.getString(4));
				vz.setAge(ex.getInt(5));
				vz.setGender(ex.getString(6));
				vz.setVisitingtime(ex.getString(7));
				vz.setVisitingDate(ex.getString(8));
				vz.setIdProofType(ex.getString(9));
				vz.setAddress(ex.getString(10));
				vz.setIdProofNumber(ex.getString(11));
				lv.add(vz);

			}
			con.close();
			return lv;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Visitor getVisitorbyContactno(String contact) {

		Connection con = getConnection();
		try {

			String query = "select * from visitor where contact_no=?";
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, contact);

			// update visitor

			ResultSet re = pt.executeQuery();
			Visitor v = new Visitor();
			if (re.next()) {
				v.setId(re.getInt(1));
				v.setName(re.getString(2));
				v.setEmail(re.getString(3));
				v.setContactno(re.getString(4));
				v.setAge(re.getInt(5));
				v.setGender(re.getString(6));
				v.setVisitingtime(re.getString(7));
				v.setVisitingDate(re.getString(8));
				v.setIdProofType(re.getString(9));
				v.setAddress(re.getString(10));
				v.setIdProofNumber(re.getString(11));

			}
			
			return v;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Visitor getVisitorbyemail(String email) {
		Connection con = getConnection();
		try {

			String query = "select * from visitor where email=?";
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, email);

			ResultSet re = pt.executeQuery();
			Visitor v = new Visitor();
			if (re.next()) {

				v.setId(re.getInt(1));
				v.setName(re.getString(2));
				v.setEmail(re.getString(3));
				v.setContactno(re.getString(4));
				v.setAge(re.getInt(5));
				v.setGender(re.getString(6));
				v.setVisitingtime(re.getString(7));
				v.setVisitingDate(re.getString(8));
				v.setIdProofType(re.getString(9));
				v.setAddress(re.getString(10));
				v.setIdProofNumber(re.getString(11));

			}

			con.close();
			return v;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Visitor getVisitorbyId(int id) {
		Connection con = getConnection();
		try {

			String query = "select * from visitor where id=?";
			PreparedStatement pt = con.prepareStatement(query);

			pt.setInt(1, id);

			ResultSet re = pt.executeQuery();
			Visitor v = new Visitor();
			if (re.next()) {

				v.setId(re.getInt(1));
				v.setName(re.getString(2));
				v.setEmail(re.getString(3));
				v.setContactno(re.getString(4));
				v.setAge(re.getInt(5));
				v.setGender(re.getString(6));
				v.setVisitingtime(re.getString(7));
				v.setVisitingDate(re.getString(8));
				v.setIdProofType(re.getString(9));
				v.setAddress(re.getString(10));
				v.setIdProofNumber(re.getString(11));

			}

			con.close();
			return v;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Visitor getVisitorbyidproofNumber(String number) {
		Connection con = getConnection();
		try {

			String query = "select * from visitor where idproofnumber=?";
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, number);

			// update visitor

			ResultSet re = pt.executeQuery();
			Visitor v = new Visitor();
			if (re.next()) {

				v.setId(re.getInt(1));
				v.setName(re.getString(2));
				v.setEmail(re.getString(3));
				v.setContactno(re.getString(4));
				v.setAge(re.getInt(5));
				v.setGender(re.getString(6));
				v.setVisitingtime(re.getString(7));
				v.setVisitingDate(re.getString(8));
				v.setIdProofType(re.getString(9));
				v.setAddress(re.getString(10));
				v.setIdProofNumber(re.getString(11));

			}

			con.close();
			return v;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Visitor deletebyID(int id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		try {

			String query = "delete from visitor where id=?";
			PreparedStatement pt = con.prepareStatement(query);

			Visitor v = getVisitorbyId(id);
			pt.setInt(1, id);

			int ex = pt.executeUpdate();
			con.close();
			return v;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Visitor deletebyemail(String email) {
		Connection con = getConnection();
		try {

			String query = "delete from visitor where email=?";
			PreparedStatement pt = con.prepareStatement(query);

			Visitor v = getVisitorbyemail(email);
			pt.setString(1, email);

			int ex = pt.executeUpdate();
			con.close();
			return v;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Visitor deletebycontactno(String contact) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		try {

			String query = "delete from visitor where contact_no=?";
			PreparedStatement pt = con.prepareStatement(query);

			Visitor v = getVisitorbyContactno(contact);
			pt.setString(1, contact);

			int ex = pt.executeUpdate();
			con.close();
			return v;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Visitor> getVisitorbyDate(String date) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		List<Visitor> lv = new ArrayList<Visitor>();

		try {

			String query = "select * from visitor where vdate=?";
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, date);
			ResultSet ex = pt.executeQuery();

			while (ex.next()) {
				Visitor v = new Visitor();
				v.setId(ex.getInt(1));
				v.setName(ex.getString(2));
				v.setEmail(ex.getString(3));
				v.setContactno(ex.getString(4));
				v.setAge(ex.getInt(5));
				v.setGender(ex.getString(6));
				v.setVisitingtime(ex.getString(7));
				v.setVisitingDate(ex.getString(8));
				v.setIdProofType(ex.getString(9));
				v.setAddress(ex.getString(10));
				v.setIdProofNumber(ex.getString(11));
				lv.add(v);

			}
			con.close();
			return lv;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
