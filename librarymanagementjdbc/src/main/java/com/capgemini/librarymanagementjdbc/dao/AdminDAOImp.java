package com.capgemini.librarymanagementjdbc.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementjdbc.dto.AdminBean;
import com.capgemini.librarymanagementjdbc.dto.BookBean;
import com.capgemini.librarymanagementjdbc.exception.AdminException;


public class AdminDAOImp implements AdminDAO{

	public boolean register(AdminBean info) {
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro)){
				String query = "insert into admin values (?,?,?,?,?)";
				try(PreparedStatement pstmt = conn.prepareStatement(query)){

					pstmt.setInt(1, info.getAid());
					pstmt.setString(2, info.getAname());
					pstmt.setLong(3, info.getMobile());
					pstmt.setString(4, info.getEmail());
					pstmt.setString(5, info.getPassword());
					int count = pstmt.executeUpdate();
					System.out.println("no of rows afftected---"+count);
					
					if(count!=0) {
						return true;
					} else {
						return false;
					}
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public AdminBean auth(String email, String password) {

		AdminBean bean = new AdminBean();

		try(FileInputStream fin = new FileInputStream("dburl.properties")){
			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(("dburl"),pro)){
				String query = "select email,password from admin where email=? and password=?";
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					LinkedList<AdminBean> bean2 = new LinkedList<AdminBean>();
					pstmt.setString(1, email);
					pstmt.setString(2, password); 
					ResultSet rs = pstmt.executeQuery();
					if(bean2.contains(pstmt)) {
						return bean;
					} else {
						System.out.println("Email doesnt exist");
					}

				} catch(AdminException ae) {
					ae.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addBook(BookBean book) {
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro)){
				String query = "insert into admin values (?,?,?,?,?)";

				try(PreparedStatement pstmt = conn.prepareStatement(query)){

					int count = pstmt.executeUpdate();

					System.out.println("no of rows afftected---"+count);
					if(count!=0) {
						return true;
					} else {
						return false;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public LinkedList<BookBean> searchBookTitle(String bname) {

		return null;
	}

	public LinkedList<BookBean> searchBookAuthor(String bAuthor) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<BookBean> searchBookType(String bookType) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateBook(int bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean removeBook(int bid) {
		// TODO Auto-generated method stub
		return false;
	}

	public LinkedList<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<BookBean> getBooksInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean issueBook(int bid) {
		// TODO Auto-generated method stub
		return false;
	}

}
