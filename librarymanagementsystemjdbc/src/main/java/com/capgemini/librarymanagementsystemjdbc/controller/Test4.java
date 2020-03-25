package com.capgemini.librarymanagementsystemjdbc.controller;

import java.util.Scanner;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.factory.AdminFactory;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;

public class Test4 {
	public static void main(String[] args) {
		doMethods();
	}
	
	public static void doMethods() {
		Scanner scanner = new Scanner(System.in);
		AdminService service = AdminFactory.getAdminService();
			do {
				System.out.println("Press 1 to Add Books");
				System.out.println("Press 2 to update");
				System.out.println("Press 3 to Search the Book by bookName");
				System.out.println("Press 4 to Search the Book by author");
				System.out.println("Press 5 to Search the Book by Id");
				System.out.println("Press 6 to remove the Books");
				System.out.println("Press 7 to Get the Book Id's");
				System.out.println("Press 8 to Get the Book Information");
				System.out.println("Press 9 to main");
				int choice1 = scanner.nextInt();
				switch (choice1) {
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
					System.out.println("No implementation");
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
						//System.out.println(list);
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
					System.out.println("Enter New Book Name to Update");
					String bname1 = scanner.next();
					System.out.println("Enter Book Name to Update");
					String bname2 = scanner.next();
					BookBean bean6 = new BookBean();
					bean6.setBname(bname1);
					bean6.setBname(bname2);
					boolean b = service.updateBook(bean6);
					if(b) {
						System.out.println("Book Updated");
					} else {
						System.out.println("Book Not Update");
					}
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}

			} while(true);
		
		}
	}

