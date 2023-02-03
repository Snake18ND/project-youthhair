package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.Account;
import com.example.doanweb.service.AccountService;

@RestController
public class AccountRestcontroller {
	
	@Autowired
	AccountService accountService;
	//get all account
	@GetMapping("/rest/account")
	public List<Account> getAll() {
		return accountService.findAll();
	}

}
