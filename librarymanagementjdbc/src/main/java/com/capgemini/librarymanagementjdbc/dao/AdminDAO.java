package com.capgemini.librarymanagementjdbc.dao;

import java.util.LinkedList;

import com.capgemini.librarymanagementjdbc.dto.AdminBean;
import com.capgemini.librarymanagementjdbc.dto.BookBean;

public interface AdminDAO {
	boolean register(AdminBean info);
	AdminBean auth(String email, String password);
	boolean addBook(BookBean book);
	LinkedList<BookBean> searchBookTitle(String bname);
	LinkedList<BookBean> searchBookAuthor(String bAuthor);
	LinkedList<BookBean> searchBookType(String bookType);
	int updateBook(int bid);
	boolean removeBook(int bid);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	boolean issueBook(int bid);
}
