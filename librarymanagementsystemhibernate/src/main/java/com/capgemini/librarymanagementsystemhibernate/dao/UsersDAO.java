package com.capgemini.librarymanagementsystemhibernate.dao;

import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;

public interface UsersDAO {
	boolean register(UsersBean info);
	UsersBean auth(String email, String password);
}
