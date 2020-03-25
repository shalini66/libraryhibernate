package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;

public interface AdminDAO {
	/*
	 * boolean register(AdminBean info); AdminBean auth(String email, String
	 * password);
	 */
	boolean addBook(BookBean book);
	BookBean searchBookTitle(String bname);
	BookBean searchBookAuthor(String bAuthor);
	BookBean searchBookType(int bookType);
	boolean updateBook(BookBean bean);
	//int updateBook(int bid);
	boolean removeBook(int bid);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	List<UsersBean> showUsers();
	List<RequestBean> showRequests();
	boolean bookIssue(UsersBean student,BookBean book);
	boolean isBookReceived(UsersBean student,BookBean book);
}
