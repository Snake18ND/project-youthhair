package com.example.doanweb.service;

import com.example.doanweb.entity.Account;
import com.example.doanweb.entity.Authority;

import java.util.List;
import java.util.Optional;

public interface AuthorityService {

    Optional<Authority> findById(Integer id);

}
