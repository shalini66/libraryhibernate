package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;

public interface StudentService {
	BookBean searchBookTitle(String bname);
	BookBean searchBookAuthor(String bAuthor);
	BookBean searchBookType(int bookType);
	List<BookBean> getBookIds();
	List<BookBean> getBooksInfo();
	boolean requestBook(int bid, String author);
	boolean returnBook(int bid);
}
