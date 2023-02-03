package com.example.doanweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.*;
import com.example.doanweb.entity.*;
import com.example.doanweb.service.BookingContactService;
import com.example.doanweb.service.BookingCustomerService;
import com.example.doanweb.service.dto.BookingContactDTO;
import com.example.doanweb.service.dto.BookingCustomerDTO;
import com.example.doanweb.service.dto.BookingIatDTO;
import com.example.doanweb.service.dto.StylistDTO;

import javax.persistence.Tuple;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class BookingContactServiceImpl  implements BookingContactService{

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


	public boolean checkNullCustomer(Customer customer){
		return customer != null ? true :false;
	}

	public boolean checkNullBooking(Booking booking){
		return booking != null ? true :false;
	}

	public BookingContactDTO AddInfoBookingCustomer(BookingContactDTO bookingContactDTO) {
		//Time time = null;
		try {
			Customer cus = cusDAO.customerByPhone(bookingContactDTO.getPhone());
			Booking booking = null;
			if(!checkNullCustomer(cus)) {
				Customer cus1 = new Customer();
				cus1.setFullName(bookingContactDTO.getFullName());
				cus1.setEmail(bookingContactDTO.getEmail());
				cus1.setPhone(bookingContactDTO.getPhone());
				cusDAO.save(cus1);
				booking = bookingDao.findCustomerInBookingWFC(cus1.getId());
				System.out.println(cus1.getId());
			}else {
				if(cus.getEmail()!= bookingContactDTO.getEmail()) {
					cus.setFullName(bookingContactDTO.getFullName());
					cus.setEmail(bookingContactDTO.getEmail());
					cusDAO.save(cus);
					booking = bookingDao.findCustomerInBookingWFC(cus.getId());
				}
			}
			Statusbooking statusBooking = statusDAO.StatusbookingbyIdWFC();
			Employee stylist = empDAO.employeeByIdStylist(bookingContactDTO.getStylistId());
			Customer cus1 = cusDAO.customerByPhone(bookingContactDTO.getPhone());
			if(!checkNullBooking(booking )) {
				Booking booking1= new Booking();
				booking1.setCreateDate(bookingContactDTO.getCreateDate());
				Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(bookingContactDTO.getTime());
				//time = new Time(date1.getTime());
//				booking1.setTime(time);
				booking1.setNote(bookingContactDTO.getNote());
				booking1.setEmployee1(stylist);
				booking1.setTotalPrice(bookingContactDTO.getTotalPrice());
				booking1.setCustomer(cus1);
				booking1.setStatusbooking(statusBooking);
				booking1.setVoting(null);
				booking1.setVoucherdetails(null);
				bookingDao.save(booking1);

				for(int i=0; i<bookingContactDTO.getListSer().size();i++ ){
					BookingDetail bookingDetail = new BookingDetail();
					bookingDetail.setBooking(booking1);
					bookingDetail.setService(bookingContactDTO.getListSer().get(i));
					bookingDetail.setPrice(bookingContactDTO.getListSer().get(i).getPrice());
//					bookingDetail.setTime(bookingContactDTO.getListSer().get(i).getTime());
					bDetailDAO.save(bookingDetail);
				}}else{

				throw new Exception("Booking Cus error");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookingContactDTO;
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
