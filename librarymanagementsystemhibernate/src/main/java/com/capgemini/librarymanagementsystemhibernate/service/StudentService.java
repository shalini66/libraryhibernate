package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;

public interface StudentService {
	BookBean searchBookTitle(String bname);
	BookBean searchBookAuthor(String bAuthor);
	BookBean searchBookType(int bookType);
	List<Integer> getBookIds();
	List<BookBean> getBooksInfo();
	RequestBean requestBook(UsersBean student, BookBean book);
	boolean returnBook(UsersBean student, BookBean book);
}
