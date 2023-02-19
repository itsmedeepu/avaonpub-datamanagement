package com.avon.avondatamanagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visitor {

	private int id;
	private String name;
	private String email;
	private String contactno;
	private int age;
	private String gender;
	private String visitingtime;
	private String visitingDate;
	private String idProofType;
	private String address;

	private String idProofNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdProofNumber() {
		return idProofNumber;
	}

	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getVisitingtime() {
		return visitingtime;
	}

	public void setVisitingtime() {
		this.visitingtime = LocalTime.now() + "";
	}

	public String getVisitingDate() {
		return visitingDate;
	}

	public void setVisitingDate() {
		this.visitingDate = LocalDate.now() + "";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public void setVisitingtime(String visitingtime) {
		this.visitingtime = visitingtime;
	}

	public void setVisitingDate(String visitingDate) {
		this.visitingDate = visitingDate;
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", name=" + name + ", email=" + email + ", contactno=" + contactno + ", age=" + age
				+ ", gender=" + gender + ", visitingtime=" + visitingtime + ", visitingDate=" + visitingDate
				+ ", idProofType=" + idProofType + ", address=" + address + ", idProofNumber=" + idProofNumber + "]";
	}

}
