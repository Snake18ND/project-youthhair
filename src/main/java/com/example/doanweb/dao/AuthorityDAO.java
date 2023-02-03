package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.doanweb.entity.Account;
import com.example.doanweb.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
}
