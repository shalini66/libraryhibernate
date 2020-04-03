package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dao.UsersDAO;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemhibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestDetails;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.factory.UsersFactory;

public class UsersServiceImp implements UsersService {
	UsersDAO dao = UsersFactory.getUsersDAO();
	public boolean register(UsersBean info) {
		return dao.register(info);
	}

	public UsersBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	public boolean addBook(BookBean book) {
		// TODO Auto-generated method stub
		return false;
	}

	public BookBean searchBookTitle(String bname) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookBean searchBookAuthor(String bAuthor) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookBean searchBookType(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateBook(BookBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeBook(int bid) {
		// TODO Auto-generated method stub
		return false;
	}

	public LinkedList<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<BookBean> getBooksInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsersBean> showUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean request(int uId, int bId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<RequestDetails> showRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean issueBook(int bId, int uId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean returnBook(int bId, int uId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<BorrowedBooks> borrowedBook(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<BookIssueDetails> bookHistoryDetails(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

}
