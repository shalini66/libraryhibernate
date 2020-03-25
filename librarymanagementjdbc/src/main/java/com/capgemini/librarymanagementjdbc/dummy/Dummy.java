package com.capgemini.librarymanagementjdbc.dummy;

import java.util.Scanner;

import com.capgemini.librarymanagementjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementjdbc.dao.AdminDAOImp;
import com.capgemini.librarymanagementjdbc.dto.AdminBean;
import com.capgemini.librarymanagementjdbc.factory.AdminFactory;
import com.capgemini.librarymanagementjdbc.service.AdminService;

public class Dummy {
	public static void main(String[] args) {
		doReg();
	}
	public static void doReg() {
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		do {
			System.out.println("Press 1 for Admin");
			System.out.println("Press 2 for Student");
			switch (choice) {
			case 1:
				AdminService service = AdminFactory.getAdminService();
				
				System.out.println("Enter ID");
				int regID = scanner.nextInt();
				System.out.println("Enter Name");
				String regName = scanner.next();
				System.out.println("Enter Mobile");
				long regMobile = scanner.nextLong();
				System.out.println("Enter Email");
				String regEmail = scanner.next();
				System.out.println("Enter Password");
				String regPassword = scanner.next();
				AdminBean bean = new AdminBean();
				bean.setAid(regID);
				
				bean.setAname(regName);
				bean.setMobile(regMobile);
				bean.setEmail(regEmail);
				bean.setPassword(regPassword);
				boolean check = service.register(bean);
				if(check) {
					System.out.println("Registered");
				} else {
					System.out.println("Email already exist");
				}	

				break;

			default:
				break;
			}

		} while(true);
	}
}
