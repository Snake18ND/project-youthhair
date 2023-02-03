package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doanweb.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer> {

}
