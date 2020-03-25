package com.capgemini.librarymanagementsystemjdbc.service;

import com.capgemini.librarymanagementsystemjdbc.dao.UsersDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.factory.UsersFactory;

public class UsersServiceImp  implements UsersService{
	UsersDAO dao = UsersFactory.getUsersDAO();
	@Override
	public boolean register(UsersBean info) {
		
		return dao.register(info);
	}

	@Override
	public UsersBean auth(String email, String password) {
		
		return dao.auth(email, password);
	}

}
