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
import com.capgemini.librarymanagementsystemjdbc.exception.AdminException;
import com.capgemini.librarymanagementsystemjdbc.exception.BookException;

public class StudentDAOImp implements StudentDAO{

//	@Override
//	public boolean register(StudentBean info) {
//		try(FileInputStream	fin = new FileInputStream("dburl.properties")){
//
//			Properties pro = new Properties();
//			pro.load(fin);
//
//			Class.forName(pro.getProperty("path")).newInstance();
//			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
//				String query = pro.getProperty("register_student");
//				try(PreparedStatement pstmt = conn.prepareStatement(query)){
//					
//					pstmt.setInt(1, info.getSid());
//					pstmt.setString(2, info.getSname());
//					pstmt.setLong(3, info.getMobile());
//					pstmt.setString(4, info.getSemail());
//					pstmt.setString(5, info.getPassword());
//					int count = pstmt.executeUpdate();
//				} throw new AdminException("invalid email and password");
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	@Override
//	public StudentBean auth(String email, String password) {
//		StudentBean bean = new StudentBean(); 
//		try(FileInputStream fin = new FileInputStream("dburl.properties")){
//			Properties pro = new Properties();
//			pro.load(fin);
//			Class.forName(pro.getProperty("path")).newInstance();
//			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
//				String query = pro.getProperty("auth_student");
//				try(PreparedStatement pstmt = conn.prepareStatement(query)){ 
//					pstmt.setString(1, email);
//					pstmt.setString(2, password); 
//
//					ResultSet rs = pstmt.executeQuery();
//					if(rs.next()) {
//						if(rs.equals(bean.getSemail().equals(email)&&bean.getPassword().equals(password))/*bean.getSemail().equals(email) && bean.getPassword().equals(password)*//*bean2.contains(email.equals(email)) && password.equals(password)*//*bean.getEmail().equals(email)&&bean.getPassword().equals(password)*//*bean2.contains(bean.getEmail().equals(email)&&bean.getPassword().equals(password))*/){
//							System.out.println("login successful");
//							return bean;
//						}
//					}
//					throw new AdminException("invalid email and password");	
//				} 
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bean;
//	}

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
	public boolean requestBook(int bid, String author) {
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);
			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = "";
				try(Statement stmt = conn.createStatement()){	
					ResultSet rs = stmt.executeQuery(query);
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean returnBook(int bid) {
		// TODO Auto-generated method stub
		return false;
	}

}
