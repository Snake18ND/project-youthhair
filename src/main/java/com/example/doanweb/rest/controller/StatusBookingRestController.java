package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.Statusbooking;
import com.example.doanweb.service.StatusBookingService;

@RestController
public class StatusBookingRestController {

	@Autowired
	StatusBookingService statusBookingService;
	
	@GetMapping("/rest/statusbooking")
	public List<Statusbooking> getAll(){
		return statusBookingService.findAll();
	}
}
