package com.capgemini.librarymanagementsystemhibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.factory.UsersFactory;
import com.capgemini.librarymanagementsystemhibernate.service.UsersService;

public class Test2 {
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

				//UsersBean bean2 = new UsersBean();
				try {
					UsersBean check1 = service.auth(regEmail1, regPassword1);
					if(check1!=null) {
						System.out.println("Login successful");
						String role = check1.getRole();
						if(role.equals("admin")) {
							do{
								doAdmin();
							}while(true);
						}
						if(role.equals("student")) {
							doStudent();
						}
					} else {
						System.out.println("login failed");
					}

				} catch (Exception e) {
					System.out.println("Invalid Credentials");
				}
				break;
			default:
				break;
			}//end of switch case
		} while(true);
	}//end of doReg

	public static void doAdmin() {
		UsersService service = UsersFactory.getUsersService();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("press 1 to add book");
			System.out.println("Press 2 to update");
			System.out.println("Press 3 to Search the Book by bookName");
			System.out.println("Press 4 to Search the Book by author");
			System.out.println("Press 5 to Search the Book by Id");
			System.out.println("Press 6 to remove the Books");
			System.out.println("Press 7 to Get the Book Id's");
			System.out.println("Press 8 to Get the Book Information");
			System.out.println("Press 9 to show users");
			System.out.println("Press 10 to Requests");
			System.out.println("Press 11 to Main");

			int a = scanner.nextInt();
			switch (a) {
			case 1:
				System.out.println("Enter ID");
				int bookId = scanner.nextInt();
				System.out.println("Enter Book Name");
				String bookName = scanner.next();
				System.out.println("Enter Author");
				String bookAuthor = scanner.next();
				System.out.println("Enter Category");
				String bookCategory = scanner.next();
				System.out.println("Enter Publisher Name");
				String bookPubName = scanner.next();

				BookBean bean2 = new BookBean();	
				bean2.setBname(bookName);
				bean2.setBid(bookId);
				bean2.setAuthor(bookAuthor);
				bean2.setCategory(bookCategory);
				bean2.setPublishername(bookPubName);
				boolean check2 = service.addBook(bean2);
				if(check2) {
					System.out.println("Book already exist");
				} else {
					System.out.println("Book Added");
				}
				break;
			case 2:
				System.out.println("Enter New Book Name to Update");
				String bname1 = scanner.next();
				System.out.println("Enter Book Name to Update");
				String bname2 = scanner.next();
				BookBean bean6 = new BookBean();
				//bean6.setBname(bname1);
				bean6.setBname(bname2);
				boolean b = service.updateBook(bean6);
				if(b) {
					System.out.println("Book Updated");
				} else {
					System.out.println("Book Not Update");
				}
				break;
			case 3:
				System.out.println("Enter book Name");
				String bookName1 = scanner.next();
				BookBean bean3 = new BookBean();
				bean3.setBname(bookName1);
				BookBean bean = service.searchBookTitle(bookName1);
				if(bean!=null) {
					System.out.println(bean.getBid());
					System.out.println(bean.getBname());
					System.out.println(bean.getAuthor());
					System.out.println(bean.getCategory());
					System.out.println(bean.getPublishername());

				} else {
					System.out.println("Book Not Found");
				}
				break;
			case 4:
				System.out.println("Enter Book author");
				String author = scanner.next();
				BookBean bean4 = new BookBean();
				bean4.setAuthor(author);
				BookBean bean1 = service.searchBookAuthor(author);
				if(bean1!=null) {
					System.out.println(bean1.getBid());
					System.out.println(bean1.getBname());
					System.out.println(bean1.getAuthor());
					System.out.println(bean1.getCategory());
					System.out.println(bean1.getPublishername());
					//System.out.println(list1);
				} else {
					System.out.println("Book Not Found");
				}
				break;
			case 5:
				System.out.println("Enter Book id");
				int id = scanner.nextInt();
				BookBean bean5 = new BookBean();
				bean5.setBid(id);
				BookBean bbean = service.searchBookType(id);
				if(bbean!=null) {
					System.out.println(bbean.getBid());
					System.out.println(bbean.getBname());
					System.out.println(bbean.getAuthor());
					System.out.println(bbean.getCategory());
					System.out.println(bbean.getPublishername());
					//System.out.println(list2);
				} else {
					System.out.println("Book Not Found");
				}
				break;
			case 6:
				System.out.println("Enter bookId to Delete");
				int bid = scanner.nextInt();
				BookBean bean7 = new BookBean();
				bean7.setBid(bid);
				boolean del = service.removeBook(bid);
				if(del) {
					System.out.println("Book Not Deleted");
				} else {
					System.out.println("Book Deleted");
				}
				break;
			case 7:
				List<Integer> list4 = service.getBookIds();
				System.out.println(list4);
				break;
			case 8:
				List<BookBean> list5 = service.getBooksInfo();
//				for(BookBean bean8 : list4) {
//					System.out.println(bean8.getBid());
//					System.out.println(bean8.getBname());
//					System.out.println(bean8.getAuthor());
//					System.out.println(bean8.getCategory());
//					System.out.println(bean8.getPublishername());
//					System.out.println("--------------------");
//				}
				System.out.println(list5);
				break;
			case 9:
				List<UsersBean> list = service.showUsers();
				System.out.println(list);
				break;
			case 10:
				//List<RequestBean> list2 = service.showRequest();
				//System.out.println(list2);
				break;
			case 11:
				doReg();
			default:
				System.out.println("Invalid Choice");
				break;
			}//end of admin methods
		} while(true); //end of do-while main
	}//end of admin
	
	
	
	public static void doStudent() {
		UsersService service = UsersFactory.getUsersService();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Press 1 to Search the Book by bookName");
			System.out.println("Press 2 to Search the Book by author");
			System.out.println("Press 3 to Search the Book by Id");
			System.out.println("Press 4 to Get the Book Id's");
			System.out.println("Press 5 to Get the Book Information");
			System.out.println("press 6 to request book");
			System.out.println("Press 8 to main");

			int a = scanner.nextInt();
			switch (a) {
			case 1:
				System.out.println("Enter book Name");
				String bookName1 = scanner.next();
				BookBean bean3 = new BookBean();
				bean3.setBname(bookName1);
				BookBean bean = service.searchBookTitle(bookName1);
				if(bean!=null) {
					System.out.println(bean.getBid());
					System.out.println(bean.getBname());
					System.out.println(bean.getAuthor());
					System.out.println(bean.getCategory());
					System.out.println(bean.getPublishername());

				} else {
					System.out.println("Book Not Found");
				}
				break;
			case 2:
				System.out.println("Enter Book author");
				String author = scanner.next();
				BookBean bean4 = new BookBean();
				bean4.setAuthor(author);
				BookBean bean1 = service.searchBookAuthor(author);
				if(bean1!=null) {
					System.out.println(bean1.getBid());
					System.out.println(bean1.getBname());
					System.out.println(bean1.getAuthor());
					System.out.println(bean1.getCategory());
					System.out.println(bean1.getPublishername());
					//System.out.println(list1);
				} else {
					System.out.println("Book Not Found");
				}
				break;
			case 3:
				System.out.println("Enter Book id");
				int id = scanner.nextInt();
				BookBean bean5 = new BookBean();
				bean5.setBid(id);
				BookBean bbean = service.searchBookType(id);
				if(bbean!=null) {
					System.out.println(bbean.getBid());
					System.out.println(bbean.getBname());
					System.out.println(bbean.getAuthor());
					System.out.println(bbean.getCategory());
					System.out.println(bbean.getPublishername());
					//System.out.println(list2);
				} else {
					System.out.println("Book Not Found");
				}
				break;
			case 4:
				List<Integer> list4 = service.getBookIds();
				System.out.println(list4);
				break;
			case 5:
				List<BookBean> list5 = service.getBooksInfo();
//				for(BookBean bean8 : list4) {
//					System.out.println(bean8.getBid());
//					System.out.println(bean8.getBname());
//					System.out.println(bean8.getAuthor());
//					System.out.println(bean8.getCategory());
//					System.out.println(bean8.getPublishername());
//					System.out.println("--------------------");
//				}
				System.out.println(list5);
				break;
				
			case 6:
				
				break;
			case 8:
				doReg();
			default:
				System.out.println("Invalid Choice");
				break;
			}//end of student methods
		} while(true); //end of do-while main

	}//end of student
}
