package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.Shifts;
import com.example.doanweb.service.ShiftsService;

@RestController
public class ShiftsRestController {
	
	@Autowired
	ShiftsService shiftsService;
	
	@GetMapping("/rest/shifts")
	public List<Shifts> findAll(){
		return shiftsService.findAll();
	}
	
	@PostMapping("/rest/shifts")
	public Shifts save(@RequestBody Shifts shifts){
		return shiftsService.save(shifts);
	}
}
