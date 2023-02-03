package com.example.doanweb.service;

import com.example.doanweb.entity.Booking;
import com.example.doanweb.service.dto.BookingCustomerDTO;
import com.example.doanweb.service.dto.BookingIatDTO;

import java.util.List;

public interface BookingCustomerService {
	BookingCustomerDTO AddInfoBookingCustomer(BookingCustomerDTO bookingCustomerDTO);
	Booking 	bookingStatusIAT(Integer id);
	List<BookingIatDTO> bookingIAT();

    Booking checkBookingUCF(String phone);
}
