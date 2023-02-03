package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.Role;
import com.example.doanweb.service.RoleService;

@RestController
public class
RoleRestController {

	@Autowired
	RoleService roleService;
	
	@GetMapping("/rest/role")
	public List<Role> getAll(){
		return roleService.findAll();
	}
}
