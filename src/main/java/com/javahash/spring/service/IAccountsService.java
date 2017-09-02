package com.javahash.spring.service;

import java.util.List;

import com.javahash.spring.model.Account;

public interface IAccountsService {
	
	public List<Account> findAll();
	
}
