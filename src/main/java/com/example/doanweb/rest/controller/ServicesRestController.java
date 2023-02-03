package com.example.doanweb.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.doanweb.entity.DichVuHot;
import com.example.doanweb.entity.Services;
import com.example.doanweb.service.IServiceService;
import com.example.doanweb.service.dto.ServiceDTO;

import java.util.*;

@RestController
@RequestMapping("/rest")
@CrossOrigin("http://localhost:8080/")
public class ServicesRestController {


	@Autowired
	IServiceService iServiceService;
	@PostMapping("/services")
	public ServiceDTO update(@RequestBody ServiceDTO serviceDTO) {
		return iServiceService.save(serviceDTO);
	}
	@GetMapping("/services")
	public List<Services>  getAll() {
		return iServiceService.findAll();
	}
	@GetMapping("/services/{id}")
	public Optional<Services> getById(@PathVariable("id") Integer id) {
		return iServiceService.findById(id);
	}

//	@PutMapping("/services/{id}")
//	public ServiceDTO update(@PathVariable("id") Integer id , @RequestBody ServiceDTO serviceDTO) {
//		return iServiceService.save(serviceDTO);
//	}

	@PutMapping("/services/delete/{id}")
	public ResponseEntity<Services> Delete(@PathVariable("id") Integer id ) {
		Services services = iServiceService.getById(id);
		return ResponseEntity.ok(iServiceService.update(services));
	}

	@GetMapping("/services/seach")
	public List<Services>  seachServiceByName(String serviceName) {
		return iServiceService.seachServiceByName(serviceName);
	}
	//TODO: Hebi
	@GetMapping("/findServiceActiveTop3")
	public List<DichVuHot> getServiceActiveTop3(){
		List<DichVuHot> lstSerTop3 = iServiceService.findServicesActiveTop3();
		return lstSerTop3;
	}
}
