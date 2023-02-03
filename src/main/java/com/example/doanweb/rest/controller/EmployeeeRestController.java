package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.example.doanweb.entity.Employee;
import com.example.doanweb.service.EmployeeService;
import com.example.doanweb.service.dto.StylistDTO;


@RestController
@RequestMapping("/rest/employee")
public class EmployeeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping()
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/active")
	public List<Employee> getAllEmployeeActive(){
		return employeeService.getAllEmployeeActive();
	}
	
	@PostMapping()
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}
	
	@GetMapping("/allStylist")
	public List<Employee> stylistActive(){
		return employeeService.bookingByStylist();
	}
	
	@PutMapping("{id}")
	public Employee update(@PathVariable("id")Integer id,@RequestBody Employee employee) {
		return employeeService.update(employee);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		employeeService.delete(id);
	}

	@GetMapping("/stylist")
	public List<StylistDTO> getAllSty(){
		return employeeService.findStocktotal();
	}

	@GetMapping("/seachEmployee")
	public List<Employee> seachEmployee(String fullName){
		return employeeService.seachEmployee(fullName);
	}

	@GetMapping("/countNv")
	public Integer countNv(){
		return employeeService.countNv();
	}

	@GetMapping("/countStyList")
	public Integer countStyList(){
		return employeeService.countStyList();
	}

	//TODO: hebi
	@GetMapping("/getAllStylistForHomePage")
	public List<Employee> getAllStylist(){
		List<Employee> listStylist = employeeService.loadStylist();
		return listStylist;
	}
}
