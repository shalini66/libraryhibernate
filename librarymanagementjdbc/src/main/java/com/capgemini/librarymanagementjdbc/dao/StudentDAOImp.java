package com.capgemini.librarymanagementjdbc.dao;

import java.util.LinkedList;

import com.capgemini.librarymanagementjdbc.dto.BookBean;
import com.capgemini.librarymanagementjdbc.dto.StudentBean;

public class StudentDAOImp implements StudentDAO{

	@Override
	public boolean register(StudentBean info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StudentBean auth(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<BookBean> searchBookTitle(String bname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<BookBean> searchBookAuthor(String bAuthor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<BookBean> searchBookType(String bookType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<BookBean> getBooksInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean requestBook(int bid, String author) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean returnBook(int bid) {
		// TODO Auto-generated method stub
		return false;
	}

}
