package com.avon.avondatacontroller;

import com.avon.avondataimp.Admindaoimp;
import com.avon.avondatamanagement.dto.Admin;

public class Admincontrol {

	public static void main(String[] args) {
		
		
		Admindaoimp ad = new Admindaoimp();
		
//		Admin n= new Admin();
//		
//		n.setUsername("deepak");
//		n.setPassword("deepak123");
		
		
		
		
		boolean admin = ad.adminLogin("deepak", "deepak123");
		
		
		System.out.println(admin);
		

	}

}
