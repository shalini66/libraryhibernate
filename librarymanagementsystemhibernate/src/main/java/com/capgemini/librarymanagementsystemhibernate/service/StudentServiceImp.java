package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dao.StudentDAO;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.factory.StudentFactory;

public class StudentServiceImp implements StudentService {
	StudentDAO dao = StudentFactory.getStudentDAO();
	public BookBean searchBookTitle(String bname) {
		
		return dao.searchBookTitle(bname);
	}

	public BookBean searchBookAuthor(String bAuthor) {
		
		return dao.searchBookAuthor(bAuthor);
	}

	public BookBean searchBookType(int bookType) {
		
		return dao.searchBookType(bookType);
	}

	public List<BookBean> getBookIds() {
		
		return dao.getBookIds();
	}

	public List<BookBean> getBooksInfo() {
		
		return dao.getBooksInfo();
	}

	public boolean requestBook(int bid, String author) {
		
		return dao.requestBook(bid, author);
	}

	public boolean returnBook(int bid) {
		
		return dao.returnBook(bid);
	}

}
