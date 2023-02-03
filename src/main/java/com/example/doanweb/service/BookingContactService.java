package com.example.doanweb.service;

import java.util.List;

import com.example.doanweb.entity.Booking;
import com.example.doanweb.service.dto.BookingContactDTO;
import com.example.doanweb.service.dto.BookingIatDTO;

public interface BookingContactService {
	BookingContactDTO AddInfoBookingCustomer(BookingContactDTO bookingContactDTO);
	Booking bookingStatusIAT(Integer id);
	List<BookingIatDTO> bookingIAT();

    Booking checkBookingUCF(String phone);
}
