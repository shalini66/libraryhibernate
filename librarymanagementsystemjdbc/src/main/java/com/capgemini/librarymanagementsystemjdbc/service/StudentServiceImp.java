package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dao.StudentDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;

import com.capgemini.librarymanagementsystemjdbc.factory.StudentFactory;

public class StudentServiceImp implements StudentService {
	private StudentDAO dao = StudentFactory.getStudentDAO();

//	@Override
//	public boolean register(StudentBean info) {
//		
//		return dao.register(info);
//	}
//
//	@Override
//	public StudentBean auth(String email, String password) {
//		
//		return dao.auth(email, password);
//	}

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
	public List<BookBean> getBookIds() {
		
		return dao.getBookIds();
	}

	@Override
	public List<BookBean> getBooksInfo() {
		
		return dao.getBooksInfo();
	}

	@Override
	public boolean requestBook(int bid, String author) {
		
		return dao.requestBook(bid, author);
	}

	@Override
	public boolean returnBook(int bid) {
		
		return dao.returnBook(bid);
	}

}
