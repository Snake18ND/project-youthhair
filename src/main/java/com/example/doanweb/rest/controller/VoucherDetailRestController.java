package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.Voucher;
import com.example.doanweb.entity.Voucherdetail;
import com.example.doanweb.service.VoucherDetailService;
import com.example.doanweb.service.dto.VoucherDetailInfoDTO;

@RestController
public class VoucherDetailRestController {
	
	@Autowired
	VoucherDetailService voucherDetailService;
	
	@GetMapping("/rest/voucherDetail")
	public List<Voucherdetail> getAllVoucherDetail(){

		return voucherDetailService.findAll();
	}
	
	@GetMapping("/rest/voucherdetailByCustomer/{id}")
	public List<Voucher> getvoucherByCus(@PathVariable("id") Integer id){

		return voucherDetailService.VoucherByCus(id);
	}

	@PostMapping("/rest/payVoucherdetail")
	public VoucherDetailInfoDTO PayBooking(@RequestBody VoucherDetailInfoDTO voucherDetailInfoDTO){
		System.out.println(voucherDetailInfoDTO);
		return voucherDetailService.completeBooking(voucherDetailInfoDTO);

	}
	
	@PostMapping("/rest/voucherDetail")
	public Voucherdetail saveVoucherDetail(@RequestBody Voucherdetail voucherDetail){
		return voucherDetailService.save(voucherDetail);
	}
}
