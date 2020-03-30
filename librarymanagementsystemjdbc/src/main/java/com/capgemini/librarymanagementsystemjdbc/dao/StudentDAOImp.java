package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.exception.BookException;

public class StudentDAOImp implements StudentDAO{

	public BookBean searchBookTitle(String bname) {
		BookBean bean = new BookBean();
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("search_book_name");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, bname);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {	
						bean.setBid(rs.getInt("bid"));
						bean.setBname(rs.getString("bname"));
						bean.setAuthor(rs.getString("author"));
						bean.setCategory(rs.getString("category"));
						bean.setPublishername(rs.getString("publishername"));
						return bean;
					} throw new BookException("Book Not Found");
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public BookBean searchBookAuthor(String bAuthor) {
		BookBean bean = new BookBean();
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("search_book_author");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, bAuthor);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {	
						bean.setBid(rs.getInt("bid"));
						bean.setBname(rs.getString("bname"));
						bean.setAuthor(rs.getString("author"));
						bean.setCategory(rs.getString("category"));
						bean.setPublishername(rs.getString("publishername"));
						return bean;
					} throw new BookException("Book Not Found");
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BookBean searchBookType(int bookType) {
		BookBean bean = new BookBean();
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("search_book_id");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setInt(1, bookType);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {	
						bean.setBid(rs.getInt("bid"));
						bean.setBname(rs.getString("bname"));
						bean.setAuthor(rs.getString("author"));
						bean.setCategory(rs.getString("category"));
						bean.setPublishername(rs.getString("publishername"));
						return bean;
					} 
					throw new BookException("Book Not Found");
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookBean> getBookIds() {
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);
			List<Integer> list = new LinkedList<Integer>();
			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("get_bookId");
				try(Statement stmt = conn.createStatement()){
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()) {
						BookBean bean = new BookBean();
						bean.setBid(rs.getInt("bid"));		
					}

				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookBean> getBooksInfo() {
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);
			List<BookBean> li = new LinkedList<BookBean>();
			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("get_allBook");
				try(Statement stmt = conn.createStatement()){	
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()) {	
						BookBean bean = new BookBean();
						bean.setBid(rs.getInt("bid"));
						bean.setBname(rs.getString("bname"));
						bean.setAuthor(rs.getString("author"));
						bean.setCategory(rs.getString("category"));
						bean.setPublishername(rs.getString("publishername"));
						li.add(bean);
					}
					return li;
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean requestBook(UsersBean student, BookBean book) {
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("get_allRequests");
				UsersBean usersBean = new UsersBean();
				int userId = usersBean.getId();
				BookBean bookBean = new BookBean();
				int bookId = bookBean.getBid();
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					ResultSet set = pstmt.executeQuery();
					
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean returnBook(UsersBean student, BookBean book) {
		// TODO Auto-generated method stub
		return false;
	}

}
