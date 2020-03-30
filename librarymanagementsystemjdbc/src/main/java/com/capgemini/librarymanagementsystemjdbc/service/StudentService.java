package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;

public interface StudentService {
	/*
	 * boolean register(StudentBean info); StudentBean auth(String email, String
	 * password);
	 */	
	
	BookBean searchBookTitle(String bname);
	BookBean searchBookAuthor(String bAuthor);
	BookBean searchBookType(int bookType);
	List<BookBean> getBookIds();
	List<BookBean> getBooksInfo();
	boolean requestBook(UsersBean student, BookBean book);
	boolean returnBook(UsersBean student, BookBean book);
}
