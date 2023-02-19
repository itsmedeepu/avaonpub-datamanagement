package com.avon.avondatadao;

import java.sql.Connection;
import java.util.List;

import com.avon.avondatamanagement.dto.Visitor;

public interface vistorDao {

	public Connection getConnection();

	public Visitor saveVisitor(Visitor vistor);

	public Visitor updateVisitor(Visitor vistor);

	public List<Visitor> getallVisitors();

	public Visitor getVisitorbyContactno(String contact);

	public Visitor getVisitorbyemail(String email);

	public Visitor getVisitorbyId(int id);

	public Visitor getVisitorbyidproofNumber(String number);

	public Visitor deletebyID(int id);

	public Visitor deletebyemail(String email);

	public Visitor deletebycontactno(String contact);

	public List<Visitor> getVisitorbyDate(String date);

}
