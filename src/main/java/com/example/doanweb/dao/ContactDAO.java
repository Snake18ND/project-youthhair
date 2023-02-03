package com.example.doanweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.doanweb.entity.Contact;

public interface ContactDAO extends JpaRepository<Contact, Integer> {

	@Query("SELECT c FROM Contact c WHERE "
			+ "c.status = ?1 "
			+ "ORDER BY c.createDate ASC")
	List<Contact> findContactStatus(Boolean status, @Param("keyword") String keyword);

	@Query(value = "SELECT c FROM Contact c WHERE (:fullName is null or c.fullName like %:fullName%) and (:status is null or c.status = :status) ")
	List<Contact> seachContact(@Param("fullName") String fullName, @Param("status") boolean status);
}
