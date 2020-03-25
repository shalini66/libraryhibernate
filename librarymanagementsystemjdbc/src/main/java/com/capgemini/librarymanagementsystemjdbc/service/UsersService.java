package com.capgemini.librarymanagementsystemjdbc.service;

import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;

public interface UsersService {
	boolean register(UsersBean info);
	UsersBean auth(String email, String password);
}
