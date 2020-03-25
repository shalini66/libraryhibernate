package com.capgemini.librarymanagementjdbc.service;

import java.util.LinkedList;

import com.capgemini.librarymanagementjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementjdbc.factory.AdminFactory;
import com.capgemini.librarymanagementjdbc.dto.AdminBean;
import com.capgemini.librarymanagementjdbc.dto.BookBean;

public class AdminServiceImp implements AdminService {

	private AdminDAO dao = AdminFactory.getAdminDAO();
	public boolean register(AdminBean info) {
		return dao.register(info) ;
	}

	public AdminBean auth(String email, String password) {
		return dao.auth(email, password);
	}
	public boolean addBook(BookBean book) {

		return dao.addBook(book);
	}

	public LinkedList<BookBean> searchBookTitle(String bTitle) {

		return dao.searchBookTitle(bTitle);
	}

	public LinkedList<BookBean> searchBookAuthor(String bAuthor) {

		return dao.searchBookAuthor(bAuthor);
	}

	public LinkedList<BookBean> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public int updateBook(int bid) {
		return dao.updateBook(bid);
	}

	public boolean removeBook(int bid) {

		return dao.removeBook(bid);
	}

	public LinkedList<Integer> getBookIds() {

		return dao.getBookIds();
	}

	public LinkedList<BookBean> getBooksInfo() {

		return dao.getBooksInfo();
	}

	public boolean issueBook(int bid) {
		
		return dao.issueBook(bid);
	}


}
