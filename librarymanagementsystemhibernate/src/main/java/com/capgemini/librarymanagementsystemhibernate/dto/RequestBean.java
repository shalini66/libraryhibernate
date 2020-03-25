package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//@Entity
@Table (name = "RequestBean")
public class RequestBean implements Serializable{
	@Column
	private BookBean bookInfo;
	@Column
	private UsersBean usersInfo;
	@Column
	private boolean isIssued;
	@Column
	private boolean isReturned;
	@Column
	private LocalDate issuedDate;
	@Column
	private LocalDate returnedDate;
}