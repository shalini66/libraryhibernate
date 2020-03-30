package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dao.StudentDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.factory.StudentFactory;

public class StudentServiceImp implements StudentService {
	private StudentDAO dao = StudentFactory.getStudentDAO();

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
	public boolean requestBook(UsersBean student, BookBean book) {
		
		return dao.requestBook(student, book);
	}

	@Override
	public boolean returnBook(UsersBean student, BookBean book) {
		
		return dao.returnBook(student, book);
	}

}
