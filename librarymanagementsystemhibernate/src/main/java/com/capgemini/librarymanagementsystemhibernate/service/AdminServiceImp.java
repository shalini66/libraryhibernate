package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dao.AdminDAO;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.factory.AdminFactory;

public class AdminServiceImp implements AdminService{
	AdminDAO dao = AdminFactory.getAdminDAO();
	public boolean addBook(BookBean book) {
		return dao.addBook(book);
	}

	public BookBean searchBookTitle(String bname) {
		
		return dao.searchBookTitle(bname);
	}

	public BookBean searchBookAuthor(String bAuthor) {
		
		return dao.searchBookAuthor(bAuthor);
	}

	public BookBean searchBookType(int bid) {
		return dao.searchBookType(bid);
	}

	public boolean updateBook(BookBean bean) {
		
		return dao.updateBook(bean);
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

	public List<UsersBean> showUsers() {
		
		return dao.showUsers();
	}

	public List<RequestBean> showRequests() {
		
		return dao.showRequests();
	}

	public boolean bookIssue(UsersBean student, BookBean book) {
		
		return dao.bookIssue(student, book);
	}

	public boolean isBookReceived(UsersBean student, BookBean book) {
		
		return dao.isBookReceived(student, book);
	}

}
