package com.avon.avondatacontroller;

import com.avon.avondataimp.Visitordaoimp;
import com.avon.avondataimp.Admindaoimp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import com.avon.avondatamanagement.dto.Admin;
import com.avon.avondatamanagement.dto.Visitor;

public class Visitorcontrol {

	public static void main(String[] args) {

		System.out.println(
				"WELCOME TO AVON PUB" + "   " + " DATE= " + LocalTime.now() + "  " + " TIME= " + LocalDate.now());
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the credentails to login");

		System.out.println("<------------------------------------------>");

		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		Admindaoimp a = new Admindaoimp();

		if (a.adminLogin(username, password)) {

			System.out.println("Admin login sucessfully");
			System.out.println("<------------------------------------------>");
			System.out.println("Choose options  to add delete get user");

			System.out.println("");

			while (true) {

				String op = sc.next();

				switch (op) {

				case "add":
					System.out.println("<------------------------------------------>");
					add();

					break;
				case "delete":

					break;

				case "update":

					break;
				default:
					System.out.println("enter correct options");

				}

			}

		} else {
			System.out.println("<------------------------------------------>");
			System.out.println("login credinatils wrong");
			return;
		}

	}

	private static void add() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter all details");
		System.out.println("<------------------------------------------>");
		System.out.println("Enter visitor NAME");

		String name = sc.nextLine();
		System.out.println("Enter visitor CONTACT NO");
		String contactno = sc.nextLine();

		System.out.println("Enter visitor EMAIL");

		String email = sc.nextLine();

		System.out.println("Enter visitor AGE");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter visitor GENDER");
		String gender = sc.nextLine();
		System.out.println("Enter visitor ADDRESS");
		String address = sc.nextLine();
		System.out.println("Enter visitor ID-PROOF-TYPE");
		String prroftype = sc.nextLine();
		System.out.println("Enter visitor ID-PROOF-NUMBER");
		String proofnumber = sc.nextLine();

		Visitordaoimp v = new Visitordaoimp();

		Visitor v1 = new Visitor();

		v1.setName(name);
		v1.setContactno(contactno);
		v1.setEmail(email);
		v1.setGender(gender);
		v1.setVisitingDate();
		v1.setVisitingtime();
		v1.setAddress(address);
		v1.setIdProofType(prroftype);
		v1.setIdProofNumber(proofnumber);
		v1.setAge(age);

		if (email == null && contactno == null && gender == null && address == null
				&& prroftype == null & proofnumber == null && age == 0) {
			System.out.println("All details are mandotry");
			return;
		}

		Visitor saveVisitor = v.saveVisitor(v1);
		System.out.println(saveVisitor);

	}

}
