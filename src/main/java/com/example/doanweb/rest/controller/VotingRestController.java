package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.Voting;
import com.example.doanweb.service.VotingService;

@RestController
public class VotingRestController {
	
	@Autowired
	VotingService votingService;
	
	@GetMapping("/rest/voting")
	public List<Voting> getAll(){
		return votingService.findAll();
	}

}
