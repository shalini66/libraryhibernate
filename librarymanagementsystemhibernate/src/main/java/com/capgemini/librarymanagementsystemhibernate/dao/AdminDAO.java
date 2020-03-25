package com.capgemini.librarymanagementsystemhibernate.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;

public interface AdminDAO {
	boolean addBook(BookBean book);
	BookBean searchBookTitle(String bname);
	BookBean searchBookAuthor(String bAuthor);
	BookBean searchBookType(int bid);
	boolean updateBook(BookBean bean);
	boolean removeBook(int bid);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	List<UsersBean> showUsers();
	List<RequestBean> showRequests();
	boolean bookIssue(UsersBean student,BookBean book);
	boolean isBookReceived(UsersBean student,BookBean book);
}
