package com.example.doanweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.AccountDAO;
import com.example.doanweb.entity.Account;
import com.example.doanweb.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	AccountDAO accountDAO;

	@Override
	public Account findById(String id) {
		return accountDAO.findById(id).get();
	}


	@Override
	public Account findByName(String username) {
		return accountDAO.findByName(username);
	}

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}


}
