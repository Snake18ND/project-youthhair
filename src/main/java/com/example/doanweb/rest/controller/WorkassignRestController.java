package com.example.doanweb.rest.controller;


import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.Workassign;
import com.example.doanweb.service.WorkassignService;
import com.example.doanweb.service.dto.ShiftByEmployeeDTO;
import com.example.doanweb.service.dto.WorkassignDateDTO;

@RestController
public class WorkassignRestController {
	
	@Autowired
	WorkassignService workassignService;
	
	@GetMapping("/rest/Workassign")
	public List<Workassign> findAll(){
		return workassignService.findAll();
	}
	
	@GetMapping("/rest/Workassign/stylist")
	public List<Workassign> findWorkassignAllStylist(){
		return workassignService.findWorkassignAllStylist();
	}
	
	@GetMapping("/rest/Workassign/stylist/{date}")
	public List<Workassign> findWorkassignStylist(@PathVariable("date") Date date){
		return workassignService.findWorkassignStylist(date);
	}
	
	@GetMapping("/rest/checkWorkassignNull")
	public List<Workassign> checkNull(Integer id){
		return workassignService.checkWorkassignNull(id);
	}
	
	@GetMapping("/rest/Workassign/disctinctDate")
	public List<WorkassignDateDTO> disctinctDate(){
		return workassignService.disctinctDate();
	}
	
	@PostMapping("/rest/Workassign")
	public Workassign save(@RequestBody Workassign workassign){
		return workassignService.save(workassign);
	}
	
	@PutMapping("/rest/Workassign")
	public Workassign update(@RequestBody Workassign workassign){
		return workassignService.save(workassign);
	}

	@GetMapping("/rest/selectShiftbyEmployee")
	public Workassign selectShift(Integer id , Date date){
		return workassignService.selectShiftByEmployeeId(id,date);
	}

}
