package com.capgemini.librarymanagementsystemjdbc.dao;

import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;

public interface UsersDAO {
	boolean register(UsersBean info);
	UsersBean auth(String email, String password);
}
