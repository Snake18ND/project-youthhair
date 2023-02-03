package com.example.doanweb.service;

import java.util.List;

import com.example.doanweb.entity.BookingDetail;
import com.example.doanweb.entity.BookingDetailPK;
import com.example.doanweb.service.dto.BookingDetailServiceDTO;
import com.example.doanweb.service.dto.ServicesIdDTO;

public interface BookingDetailService {

	List<BookingDetail> findAll();

	List<BookingDetailServiceDTO> getServiceByIdBooking(Integer id);

	List<ServicesIdDTO> getBookingByIDBooking(Integer id);

    void procedure_delete(int id);

    void deleteByBookingId(int id);
}
