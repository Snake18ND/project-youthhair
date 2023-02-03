package com.example.doanweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.doanweb.dao.AccountDAO;
import com.example.doanweb.dao.AuthorityDAO;
import com.example.doanweb.entity.Account;
import com.example.doanweb.entity.Authority;
import com.example.doanweb.service.AccountService;
import com.example.doanweb.service.AuthorityService;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorityServiceImpl implements AuthorityService {

	
	@Autowired
	AuthorityDAO authorityDAO;

	@Override
	public Optional<Authority> findById(Integer id) {
		return authorityDAO.findById(id);
	}

}
