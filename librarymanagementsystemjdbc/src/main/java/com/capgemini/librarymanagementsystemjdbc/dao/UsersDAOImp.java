package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.exception.AdminException;

public class UsersDAOImp implements UsersDAO {

	@Override
	public boolean register(UsersBean info) {
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/library_management_system";
			try (Connection conn = DriverManager.getConnection(dburl, "root", "root")) {
				String query = "insert into users values(?,?,?,?,?,?)";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setInt(1, info.getId());
					pstmt.setString(2, info.getName());
					pstmt.setLong(3, info.getMobile());
					pstmt.setString(4, info.getEmail());
					pstmt.setString(5, info.getPassword());
					pstmt.setString(6, info.getRole());
					int count = pstmt.executeUpdate();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UsersBean auth(String email, String password) {
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
				String query = pro.getProperty("auth");
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setString(1, email);
					pstmt.setString(2, password);
					ResultSet set = pstmt.executeQuery();
//					List<UsersBean> list = new LinkedList<UsersBean>();
//					for(UsersBean bean : list) {
//						if(bean.getEmail().equals(email)&&bean.getPassword().equals(password)) {
//							return bean;
//						} 
//					} throw new AdminException("Invalid Email and Password");
					
					//					while(set.next()) {
					//						UsersBean bean = new UsersBean();
					//						if(bean.getEmail().equals(email)&&bean.getPassword().equals(password)) {
					//							
					//							return bean;
					//						}
					//					} throw new AdminException("Invalid Email and Password");
						
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

}