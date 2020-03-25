package com.capgemini.librarymanagementsystemhibernate.service;

import com.capgemini.librarymanagementsystemhibernate.dao.UsersDAO;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.factory.UsersFactory;

public class UsersServiceImp implements UsersService {
	UsersDAO dao = UsersFactory.getUsersDAO();
	public boolean register(UsersBean info) {
		return dao.register(info);
	}

	public UsersBean auth(String email, String password) {
		return dao.auth(email, password);
	}

}
