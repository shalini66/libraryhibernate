package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;

public interface StudentDAO {
	/*
	 * boolean register(StudentBean info); StudentBean auth(String email, String
	 * password);
	 */
	BookBean searchBookTitle(String bname);
	BookBean searchBookAuthor(String bAuthor);
	BookBean searchBookType(int bookType);
	List<BookBean> getBookIds();
	List<BookBean> getBooksInfo();
	boolean requestBook(int bid, String author);
	boolean returnBook(int bid);
}
