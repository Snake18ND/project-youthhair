package com.example.doanweb.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.doanweb.entity.BookingDetail;
import com.example.doanweb.service.BookingDetailService;
import com.example.doanweb.service.dto.BookingDetailServiceDTO;
import com.example.doanweb.service.dto.ServicesIdDTO;

@RestController
public class BookingDetailRestController {


	@Autowired
	BookingDetailService bookingDetailService;
	@GetMapping("/rest/bookingdetail")
	public List<BookingDetail> getAll(){
		return bookingDetailService.findAll();
	}

	@GetMapping("/rest/bookingdetailByIdBooking/{id}")
	public List<BookingDetailServiceDTO> getServiceByIdBooking(@PathVariable("id") Integer id){
		return bookingDetailService.getServiceByIdBooking(id);
	}

	@GetMapping("/rest/bookingDetailsByBookingID/{id}")
	public List<ServicesIdDTO> bookingDetailsByBookingID(@PathVariable Integer id){
		return bookingDetailService.getBookingByIDBooking(id);
	}

	@DeleteMapping("/rest/delete/{id}")
	void delete(@PathVariable int id){
		bookingDetailService.deleteByBookingId(id);
	}
}
