package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import com.example.doanweb.entity.Account;
import com.example.doanweb.entity.Booking;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account, String> {

    @Query(value = "SELECT b FROM Account b WHERE b.username = ?1")
    Account findByName(String username);

}
