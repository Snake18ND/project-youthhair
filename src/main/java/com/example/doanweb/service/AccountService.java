package com.example.doanweb.service;

import java.util.List;

import com.example.doanweb.entity.Account;

public interface AccountService {

    Account findById(String id);

    Account findByName(String username);

    List<Account> findAll();
}
