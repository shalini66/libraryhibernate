package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementsystemjdbc.factory.AdminFactory;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;

public class AdminServiceImp implements AdminService{

	private AdminDAO dao = AdminFactory.getAdminDAO();
//	@Override
//	public boolean register(AdminBean info) {
//		return dao.register(info) ;
//	}
//
//	@Override
//	public AdminBean auth(String email, String password) {
//		return dao.auth(email, password);
//	}

	@Override
	public boolean addBook(BookBean book) {
		return dao.addBook(book);
	}

	@Override
	public BookBean searchBookTitle(String bname) {
		
		return dao.searchBookTitle(bname);
	}

	@Override
	public BookBean searchBookAuthor(String bAuthor) {
		
		return dao.searchBookAuthor(bAuthor);
	}

	@Override
	public BookBean searchBookType(int bookType) {
		
		return dao.searchBookType(bookType);
	}

	@Override
	public boolean updateBook(BookBean bean) {
		
		return dao.updateBook(bean);
	}

	@Override
	public boolean removeBook(int bid) {
		
		return dao.removeBook(bid);
	}

	@Override
	public LinkedList<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<BookBean> getBooksInfo() {
		
		return dao.getBooksInfo();
	}

	@Override
	public boolean issueBook(int bid) {
		return false;
		//return dao.issueBook(bid);
	}

}
