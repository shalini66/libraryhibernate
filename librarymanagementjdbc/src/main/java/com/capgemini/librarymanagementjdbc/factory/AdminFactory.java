package com.capgemini.librarymanagementjdbc.factory;

import com.capgemini.librarymanagementjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementjdbc.dao.AdminDAOImp;
import com.capgemini.librarymanagementjdbc.service.AdminService;
import com.capgemini.librarymanagementjdbc.service.AdminServiceImp;

public class AdminFactory {
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImp();
	}
	public static AdminService  getAdminService() {
		return new AdminServiceImp();
	}
}
