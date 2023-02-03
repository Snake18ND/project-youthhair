package com.example.doanweb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import com.example.doanweb.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT b FROM Customer b WHERE b.phone= ?1")
    Customer customerByPhone(String phone);

    @Query(value = "SELECT c FROM Customer c WHERE :fullName is null or c.fullName like %:fullName% ")
    List<Customer> seachCustomer(@Param("fullName") String fullName);
}
