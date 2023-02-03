package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.Customer;
import com.example.doanweb.entity.Voucher;
import com.example.doanweb.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired 
	CustomerService customerSerivce;
	
	@GetMapping("/rest/customer")
	public List<Customer> getAll(){
		return customerSerivce.findAll();
	}

	
	@PutMapping("/rest/customer/{id}")
	public Customer update(@PathVariable("id")String id,@RequestBody Customer customer) {
		return customerSerivce.save(customer);
	}

	@GetMapping("/rest/customer/seachCustomer")
	public List<Customer> seachCustomer(String fullName){
		return customerSerivce.seachCustomer(fullName);
	}
}
