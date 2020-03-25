package com.capgemini.librarymanagementsystemhibernate.controller;

import java.util.Scanner;

import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.factory.UsersFactory;
import com.capgemini.librarymanagementsystemhibernate.service.UsersService;

public class TestProject {
	public static void main(String[] args) {
		doReg();
	}
	
	public static void doReg() {
		Scanner scanner = new Scanner(System.in);
		do {
			UsersService service = UsersFactory.getUsersService();
			System.out.println("press 1 for registration");
			System.out.println("press 2 for authentication");
			int a = scanner.nextInt();
			switch (a) {
			case 1:
				System.out.println("Enter Name");
				String regName = scanner.next();
				System.out.println("Enter ID");
				int regID = scanner.nextInt();
				System.out.println("Enter Mobile");
				long regMobile = scanner.nextLong();
				System.out.println("Enter Email");
				String regEmail = scanner.next();
				System.out.println("Enter Password");
				String regPassword = scanner.next();
				System.out.println("Enter role");
				String regRole = scanner.next();

				UsersBean bean = new UsersBean();
				bean.setName(regName);
				bean.setId(regID);
				bean.setMobile(regMobile);
				bean.setEmail(regEmail);
				bean.setPassword(regPassword);
				bean.setRole(regRole);
				boolean check = service.register(bean);
				System.out.println(check);
				if(check) {
					System.out.println("Email already exist");
				} else {
					System.out.println("registered");
				}
				break;
			case 2:
				System.out.println("Enter Email");
				String regEmail1 = scanner.next();
				System.out.println("Enter Password");
				String regPassword1 = scanner.next();
				UsersBean bean2 = new UsersBean();
				try {
					UsersBean check1 = service.auth(regEmail1, regPassword1);
					if(check1!=null) {
						System.out.println("Login successful");
					} else {
						System.out.println("login failed");
					}

				} catch (Exception e) {
					System.out.println("Invalid Credentials");
				}
				break;
			default:
				break;
			}
		} while(true);
	}
}