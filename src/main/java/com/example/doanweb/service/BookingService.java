package com.example.doanweb.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.doanweb.entity.Booking;
import com.example.doanweb.entity.Employee;
import com.example.doanweb.entity.ThongBaoUCF;
import com.example.doanweb.service.dto.BookingDTO;

public interface BookingService {

	<S extends Booking> List<S> findAll(Example<S> example, Sort sort);

	<S extends Booking> List<S> findAll(Example<S> example);

	Booking getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Booking> entities);

	Booking getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Booking entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Booking> entities);

	<S extends Booking> boolean exists(Example<S> example);

	<S extends Booking> long count(Example<S> example);

	void deleteInBatch(Iterable<Booking> entities);

	<S extends Booking> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Booking> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Booking> S saveAndFlush(S entity);

	void flush();

	<S extends Booking> List<S> saveAll(Iterable<S> entities);

	Optional<Booking> findById(Integer id);

	List<Booking> findAllById(Iterable<Integer> ids);

	List<Booking> findAll(Sort sort);

	List<Booking> findAll();

	Page<Booking> findAll(Pageable pageable);

	<S extends Booking> Optional<S> findOne(Example<S> example);

	<S extends Booking> S save(S entity);

	List<Booking> findBookingByStatusbooking(String status);

    String[] finbyEmployee();

	List<Employee> findByRoleAndSatus();

    List<Booking> findByStatusWFCAndStylist(int id);

	Booking findBookingIATbyStylist(Integer id);

	List<Booking> findBookingWFCbyStylist(Integer id, Date date);

	List<Booking> getAllBookingIAT();

    String[] getAllTimeBooking();

    BookingDTO AddInfoBookingUpdate(BookingDTO bookingDTO);

    BookingDTO AddInfoBookingUpdateToWFC(BookingDTO bookingDTO);

    BookingDTO AddInfoBookingUpdateWFC(BookingDTO bookingDTO);

    Booking updateCAN(int id);

	List<Booking>seachBooking(String toDate, String formDate, String statusId,String cusName);

	List<ThongBaoUCF> alertBookingUCF();
}
