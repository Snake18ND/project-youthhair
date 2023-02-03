package com.example.doanweb.service.impl;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.*;
import com.example.doanweb.entity.*;
import com.example.doanweb.service.BookingService;
import com.example.doanweb.service.TimeBookingService;
import com.example.doanweb.service.dto.BookingDTO;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    BookingDetailDAO bookingDetailDAO;

    @Autowired
    StatusBookingDAO statusBookingDAO;

    @Autowired
    TimeBookingDAO timeBookingDAO;

    @Autowired
    TimeBookingDetailDAO timeBookingDetailDAO;

    @Override
    public <S extends Booking> S save(S entity) {
        return bookingDAO.save(entity);
    }

    @Override
    public <S extends Booking> Optional<S> findOne(Example<S> example) {
        return bookingDAO.findOne(example);
    }

    @Override
    public Page<Booking> findAll(Pageable pageable) {
        return bookingDAO.findAll(pageable);
    }

    @Override
    public List<Booking> findAll() {
        return bookingDAO.findAll();
    }

    @Override
    public List<Booking> findAll(Sort sort) {
        return bookingDAO.findAll(sort);
    }

    @Override
    public List<Booking> findAllById(Iterable<Integer> ids) {
        return bookingDAO.findAllById(ids);
    }

    @Override
    public Optional<Booking> findById(Integer id) {
        return bookingDAO.findById(id);
    }

    @Override
    public <S extends Booking> List<S> saveAll(Iterable<S> entities) {
        return bookingDAO.saveAll(entities);
    }

    @Override
    public void flush() {
        bookingDAO.flush();
    }

    @Override
    public <S extends Booking> S saveAndFlush(S entity) {
        return bookingDAO.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return bookingDAO.existsById(id);
    }

    @Override
    public <S extends Booking> List<S> saveAllAndFlush(Iterable<S> entities) {
        return bookingDAO.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Booking> Page<S> findAll(Example<S> example, Pageable pageable) {
        return bookingDAO.findAll(example, pageable);
    }

    @Override
    public void deleteInBatch(Iterable<Booking> entities) {
        bookingDAO.deleteInBatch(entities);
    }

    @Override
    public <S extends Booking> long count(Example<S> example) {
        return bookingDAO.count(example);
    }

    @Override
    public <S extends Booking> boolean exists(Example<S> example) {
        return bookingDAO.exists(example);
    }

    @Override
    public void deleteAllInBatch(Iterable<Booking> entities) {
        bookingDAO.deleteAllInBatch(entities);
    }

    @Override
    public long count() {
        return bookingDAO.count();
    }

    @Override
    public void deleteById(Integer id) {
        bookingDAO.deleteById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        bookingDAO.deleteAllByIdInBatch(ids);
    }

    @Override
    public void delete(Booking entity) {
        bookingDAO.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        bookingDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAllInBatch() {
        bookingDAO.deleteAllInBatch();
    }

    @Override
    public Booking getOne(Integer id) {
        return bookingDAO.getOne(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Booking> entities) {
        bookingDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        bookingDAO.deleteAll();
    }

    @Override
    public Booking getById(Integer id) {
        return bookingDAO.getById(id);
    }

    @Override
    public <S extends Booking> List<S> findAll(Example<S> example) {
        return bookingDAO.findAll(example);
    }

    @Override
    public <S extends Booking> List<S> findAll(Example<S> example, Sort sort) {
        return bookingDAO.findAll(example, sort);
    }

    @Override
    public List<Booking> findBookingByStatusbooking(String status) {
        return bookingDAO.bookingByStatus(status);
    }

    @Override
    public String[] finbyEmployee() {
        return bookingDAO.finbyEmployee();
    }

    @Override
    public List<Employee> findByRoleAndSatus() {
        return bookingDAO.findByRoleAndSatus();
    }

    @Query("SELECT b FROM Booking b WHERE b.statusbooking.id = ?1")
    public List<Booking> bookingByStatus(String status) {
        return bookingDAO.bookingByStatus(status);
    }

    @Override
    public List<Booking> findByStatusWFCAndStylist(int id) {
        return bookingDAO.findByStatusWFCAndStylist(id);
    }

    @Override
    public Booking findBookingIATbyStylist(Integer id) {
        return bookingDAO.findBookingIATbyStylist(id);
    }

    @Override
    public List<Booking> findBookingWFCbyStylist(Integer id, Date date) {
        return bookingDAO.findBookingWFCbyStylist(id, date);
    }

    @Override
    public List<Booking> getAllBookingIAT() {
        return bookingDAO.getAllBookingIAT();
    }

    @Override
    public String[] getAllTimeBooking() {
        return bookingDAO.findByTimeBooking();
    }

    @Override
    public BookingDTO AddInfoBookingUpdate(BookingDTO bookingDTO) {
        Time time = null;
        try {
            Statusbooking statusBooking = statusBookingDAO.StatusBookigByIdCOM();
            TimeBooking timeBooking = new TimeBooking();
            if (!bookingDTO.getTimeBooking().contains("h")) {
                timeBooking = timeBookingDAO.findById(Integer.parseInt(bookingDTO.getTimeBooking())).get();
            } else {
                timeBooking.setName(bookingDTO.getTimeBooking());
            }
            Employee stylist = employeeDAO.employeeByIdStylist(bookingDTO.getEmployee1().get(0).getId());
            Booking booking1 = bookingDAO.findById(bookingDTO.getId()).get();
            booking1.setCreateDate(bookingDTO.getCreateDate());
            booking1.setTimeBooking(timeBooking.getName());
            booking1.setNote(bookingDTO.getNote());
            booking1.setEmployee1(stylist);
            booking1.setTotalPrice(bookingDTO.getTotalPrice());
            booking1.setStatusbooking(statusBooking);
            bookingDAO.save(booking1);
            bookingDetailDAO.deleteByBookingId(bookingDTO.getId());
            for (int i = 0; i < bookingDTO.getListSer().size(); i++) {
                BookingDetail bookingDetail = new BookingDetail();
                bookingDetail.setBooking(booking1);
                bookingDetail.setService(bookingDTO.getListSer().get(i));
                bookingDetail.setPrice(bookingDTO.getListSer().get(i).getPrice());
//					bookingDetail.setTime(bookingDTO.getListSer().get(i).getTime());
                bookingDetailDAO.save(bookingDetail);
            }
            if (bookingDTO.getListTime() != null) {
//				timeBookingDetailDAO.delete(bookingDTO.getId());
                for (int i = 0; i < bookingDTO.getListTime().size(); i++) {
                    TimeBookingDetail timeBookingDetailDetail = new TimeBookingDetail();
                    timeBookingDetailDetail.setBookingId(booking1.getId());
                    timeBookingDetailDetail.setTimeBookingId(bookingDTO.getListTime().get(i));
                    timeBookingDetailDetail.setDate(bookingDTO.getCreateDate());
                    timeBookingDetailDetail.setStylistId(bookingDTO.getEmployee1().get(0).getId());
                    timeBookingDetailDAO.save(timeBookingDetailDetail);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingDTO;
    }

    @Override
    public BookingDTO AddInfoBookingUpdateToWFC(BookingDTO bookingDTO) {
        Time time = null;
        try {
            Statusbooking statusBooking = statusBookingDAO.StatusbookingbyIdWFC();
            TimeBooking timeBooking = new TimeBooking();
            if (!bookingDTO.getTimeBooking().contains("h")) {
                timeBooking = timeBookingDAO.findById(Integer.parseInt(bookingDTO.getTimeBooking())).get();
            } else {
                timeBooking.setName(bookingDTO.getTimeBooking());
            }
            Employee stylist = employeeDAO.employeeByIdStylist(bookingDTO.getEmployee1().get(0).getId());
            Booking booking1 = bookingDAO.findById(bookingDTO.getId()).get();
            booking1.setCreateDate(bookingDTO.getCreateDate());
            booking1.setTimeBooking(timeBooking.getName());
            booking1.setNote(bookingDTO.getNote());
            booking1.setEmployee1(stylist);
            booking1.setTotalPrice(bookingDTO.getTotalPrice());
            booking1.setStatusbooking(statusBooking);
            bookingDAO.save(booking1);
            bookingDetailDAO.deleteByBookingId(bookingDTO.getId());
            for (int i = 0; i < bookingDTO.getListSer().size(); i++) {
                BookingDetail bookingDetail = new BookingDetail();
                bookingDetail.setBooking(booking1);
                bookingDetail.setService(bookingDTO.getListSer().get(i));
                bookingDetail.setPrice(bookingDTO.getListSer().get(i).getPrice());
//					bookingDetail.setTime(bookingDTO.getListSer().get(i).getTime());
                bookingDetailDAO.save(bookingDetail);
            }
            if (bookingDTO.getListTime() != null) {
                timeBookingDetailDAO.delete(bookingDTO.getId());
                for (int i = 0; i < bookingDTO.getListTime().size(); i++) {
                    TimeBookingDetail timeBookingDetailDetail = new TimeBookingDetail();
                    timeBookingDetailDetail.setBookingId(booking1.getId());
                    timeBookingDetailDetail.setTimeBookingId(bookingDTO.getListTime().get(i));
                    timeBookingDetailDetail.setDate(bookingDTO.getCreateDate());
                    timeBookingDetailDetail.setStylistId(bookingDTO.getEmployee1().get(0).getId());
                    timeBookingDetailDAO.save(timeBookingDetailDetail);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingDTO;
    }

    @Override
    public BookingDTO AddInfoBookingUpdateWFC(BookingDTO bookingDTO) {
        Time time = null;
        try {
            Employee stylist = employeeDAO.employeeByIdStylist(bookingDTO.getEmployee1().get(0).getId());
            Booking booking1 = bookingDAO.findById(bookingDTO.getId()).get();
            booking1.setCreateDate(bookingDTO.getCreateDate());
            booking1.setTimeBooking(bookingDTO.getTimeBooking());
            booking1.setNote(bookingDTO.getNote());
            booking1.setEmployee1(stylist);
            booking1.setTotalPrice(bookingDTO.getTotalPrice());
            bookingDAO.save(booking1);
            bookingDetailDAO.deleteByBookingId(bookingDTO.getId());
            for (int i = 0; i < bookingDTO.getListSer().size(); i++) {
                BookingDetail bookingDetail = new BookingDetail();
                bookingDetail.setBooking(booking1);
                bookingDetail.setService(bookingDTO.getListSer().get(i));
                bookingDetail.setPrice(bookingDTO.getListSer().get(i).getPrice());
//				bookingDetail.setTime(bookingDTO.getListSer().get(i).getTime());
                bookingDetailDAO.save(bookingDetail);
            }

            if (bookingDTO.getListTime() != null) {
                timeBookingDetailDAO.delete(bookingDTO.getId());
                for (int i = 0; i < bookingDTO.getListTime().size(); i++) {
                    TimeBookingDetail timeBookingDetailDetail = new TimeBookingDetail();
                    timeBookingDetailDetail.setBookingId(booking1.getId());
                    timeBookingDetailDetail.setTimeBookingId(bookingDTO.getListTime().get(i));
                    timeBookingDetailDetail.setDate(bookingDTO.getCreateDate());
                    timeBookingDetailDetail.setStylistId(bookingDTO.getEmployee1().get(0).getId());
                    timeBookingDetailDAO.save(timeBookingDetailDetail);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingDTO;
    }

    @Override
    public Booking updateCAN(int id) {
        Booking booking = bookingDAO.findById(id).get();
        Statusbooking statusbooking = statusBookingDAO.StatusBookigByIdCAN();
        booking.setStatusbooking(statusbooking);
        bookingDAO.save(booking);
        return booking;
    }

    @Override
    public List<Booking> seachBooking(String toDateStr, String formDateStr, String statusId, String cusName) {
        java.sql.Date toDate = null;
        java.sql.Date formDate = null;
        //check thêm điều kiện
        if (!toDateStr.equals("undefined")) {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date toDateUt = null;
            Date formDateUt = null;
            try {
                toDateUt = format.parse(toDateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            toDate = new java.sql.Date(toDateUt.getTime());
        }

        if (!formDateStr.equals("undefined")) {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date formDateUt = null;
            try {
                formDateUt = format.parse(formDateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            formDate = new java.sql.Date(formDateUt.getTime());
        }

        List<Booking> bookings = bookingDAO.seachBooking(toDate, formDate, statusId, cusName);

        return bookings;
    }

    @Override
    public List<ThongBaoUCF> alertBookingUCF() {
        return bookingDAO.alertBookingUCF();
    }
}
