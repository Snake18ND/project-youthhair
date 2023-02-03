package com.example.doanweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.*;
import com.example.doanweb.entity.*;
import com.example.doanweb.service.BookingCustomerService;
import com.example.doanweb.service.dto.BookingCustomerDTO;
import com.example.doanweb.service.dto.BookingIatDTO;
import com.example.doanweb.service.dto.StylistDTO;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class BookingCustomerServiceImpl  implements BookingCustomerService{

	@Autowired
	BookingDAO bookingDao;

	@Autowired
	BookingDetailDAO bDetailDAO;

	@Autowired
	ServiceDAO serDao;

	@Autowired
	CustomerDAO cusDAO;

	@Autowired
	StatusBookingDAO statusDAO;

	@Autowired
	EmployeeDAO empDAO;

	@Autowired
	TimeBookingDetailDAO timeBookingDetailDAO;

	public boolean checkNullCustomer(Customer customer){
		return customer != null ? true :false;
	}

	public boolean checkNullBooking(Booking booking){
		return booking != null ? true :false;
	}

	public BookingCustomerDTO AddInfoBookingCustomer(BookingCustomerDTO bookingCustomerDTO) {

		try {
			Customer cus = cusDAO.customerByPhone(bookingCustomerDTO.getPhone());
			Booking booking = null;
			if(!checkNullCustomer(cus)) {
				Customer cus1 = new Customer();
				cus1.setFullName(bookingCustomerDTO.getFullName());
				cus1.setEmail(bookingCustomerDTO.getEmail());
				cus1.setPhone(bookingCustomerDTO.getPhone());
				cusDAO.save(cus1);
				booking = bookingDao.bookingByCustomer(cus1.getId());
				System.out.println(cus1.getId());
			}else {
				if(cus.getEmail()!= bookingCustomerDTO.getEmail()) {
					cus.setFullName(bookingCustomerDTO.getFullName());
					cus.setEmail(bookingCustomerDTO.getEmail());
					cusDAO.save(cus);
					booking = bookingDao.bookingByCustomer(cus.getId());
				}
			}
			Statusbooking statusBooking = statusDAO.StatusbookingbyId();
			Employee stylist = empDAO.employeeByIdStylist(bookingCustomerDTO.getStylistId());
			Customer cus1 = cusDAO.customerByPhone(bookingCustomerDTO.getPhone());
			if(!checkNullBooking(booking )) {
				Booking booking1= new Booking();
				booking1.setCreateDate(bookingCustomerDTO.getCreateDate());
				booking1.setTimeBooking(bookingCustomerDTO.getTimeBooking());
				booking1.setNote(bookingCustomerDTO.getNote());
				booking1.setEmployee1(stylist);
				booking1.setTotalPrice(bookingCustomerDTO.getTotalPrice());
				booking1.setCustomer(cus1);
				booking1.setStatusbooking(statusBooking);
				booking1.setVoting(null);
				booking1.setVoucherdetails(null);
				bookingDao.save(booking1);
				for(int i=0; i<bookingCustomerDTO.getListSer().size();i++ ){
					BookingDetail bookingDetail = new BookingDetail();
					bookingDetail.setBooking(booking1);
					bookingDetail.setService(bookingCustomerDTO.getListSer().get(i));
					bookingDetail.setPrice(bookingCustomerDTO.getListSer().get(i).getPrice());
					bDetailDAO.save(bookingDetail);
				}
				for(int i=0; i<bookingCustomerDTO.getListTime().size();i++ ){
					TimeBookingDetail timeBookingDetailDetail = new TimeBookingDetail();
					timeBookingDetailDetail.setBookingId(booking1.getId());
					timeBookingDetailDetail.setTimeBookingId(bookingCustomerDTO.getListTime().get(i));
					timeBookingDetailDetail.setDate(bookingCustomerDTO.getCreateDate());
					timeBookingDetailDetail.setStylistId(bookingCustomerDTO.getStylistId());
					timeBookingDetailDAO.save(timeBookingDetailDetail);
				}
		}else{
				throw new Exception("Booking Cus error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookingCustomerDTO;
	}


	public Booking bookingStatusIAT(Integer id){
		return bookingDao.bookingCusByStylist(id);
	}

	public List<BookingIatDTO> bookingIAT(){

		List<Tuple> stockTotalTuples = bookingDao.bookingIAT();
		List<BookingIatDTO> stockTotalDto = stockTotalTuples.stream()
				.map(t -> new BookingIatDTO(
						t.get(0, Integer.class)
						//t.get(1, Time.class)
				))
				.collect(Collectors.toList());

		return stockTotalDto;
	}

	@Override
	public Booking checkBookingUCF(String phone) {
		return bookingDao.checkBookingUCF(phone);
	}
}
