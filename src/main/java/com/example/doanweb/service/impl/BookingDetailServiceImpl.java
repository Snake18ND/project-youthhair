package com.example.doanweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.BookingDetailDAO;
import com.example.doanweb.entity.BookingDetail;
import com.example.doanweb.service.BookingDetailService;
import com.example.doanweb.service.dto.BookingDetailServiceDTO;
import com.example.doanweb.service.dto.ServicesIdDTO;

import javax.persistence.Tuple;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {

	@Autowired
	BookingDetailDAO bookingDetailDAO;


	@Override
	public List<BookingDetail> findAll() {
		return bookingDetailDAO.findAll();
	}

	public List<BookingDetailServiceDTO> getServiceByIdBooking(Integer id){
		List<Tuple> stockTotalTuples = bookingDetailDAO.selectServiceByIdBooking(id);
		List<BookingDetailServiceDTO> stockTotalDto = stockTotalTuples.stream()
				.map(t -> new BookingDetailServiceDTO(
						t.get(0, String.class),
						t.get(1, String.class)

				))
				.collect(Collectors.toList());

		return stockTotalDto;
	}

	@Override
	public List<ServicesIdDTO> getBookingByIDBooking(Integer id) {
		List<Tuple> stockTotalTuples = bookingDetailDAO.getBookingByIDBooking(id);
		List<ServicesIdDTO> stockTotalDto = stockTotalTuples.stream()
				.map(t -> new ServicesIdDTO(
						t.get(0, Integer.class)
				))
				.collect(Collectors.toList());

		return stockTotalDto;
	}

	@Override
	public void procedure_delete(int id) {
		bookingDetailDAO.procedure_delete(id);
	}

	@Override
	public void deleteByBookingId(int id) {
		bookingDetailDAO.deleteByBookingId(id);
	}
}
