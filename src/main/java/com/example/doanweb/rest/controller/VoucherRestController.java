package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.doanweb.entity.Voucher;
import com.example.doanweb.service.VoucherDetailService;
import com.example.doanweb.service.VoucherService;
@CrossOrigin("*")
@RestController
public class VoucherRestController {
	@Autowired
	VoucherService voucherService;
	

	@GetMapping("/rest/voucher")
	public List<Voucher> getAll(){
		return voucherService.findAll();
	}

	@GetMapping("/rest/voucher/{id}")
	public Voucher getOne(@PathVariable("id")String id) {
		return voucherService.findById(id);
	}

	@PostMapping("/rest/voucher")
	public Voucher create( @RequestBody Voucher voucher) {
		return voucherService.save(voucher);
	}

	@PutMapping("/rest/voucher/{id}")
	public Voucher update(@PathVariable("id")String id,@RequestBody Voucher voucher) {
		return voucherService.save(voucher);
	}

	@DeleteMapping("/rest/voucher/{id}")
	public void delete(@PathVariable("id")String id) {
		voucherService.delete(id);
	}

	@GetMapping("/rest/voucher/seachVoucher")
	public List<Voucher> seachVoucher(String id){
		return voucherService.seachVoucher(id);
	}
}
