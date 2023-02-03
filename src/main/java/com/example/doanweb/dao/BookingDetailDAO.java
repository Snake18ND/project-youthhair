package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import com.example.doanweb.entity.Booking;
import com.example.doanweb.entity.BookingDetail;
import com.example.doanweb.entity.BookingDetailPK;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.List;

public interface BookingDetailDAO extends JpaRepository<BookingDetail, BookingDetailPK>{
    @Query(value = "SELECT s.service.serviceName,s.service.image FROM BookingDetail s WHERE s.booking.id =?1")
    List<Tuple> selectServiceByIdBooking(Integer id);

    @Query(value = "SELECT b.service.id FROM BookingDetail b where b.booking.id=?1")
    List<Tuple> getBookingByIDBooking(Integer id);

    @Query(value = "SELECT b FROM BookingDetail b where b.booking.id=?1")
    List<BookingDetail> findByBooking(Integer id);

    @Query(value = "DELETE FROM BookingDetail b where b.booking.id=?1")
    void deleteById(int id);

    @Procedure
    void procedure_delete(int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM BookingDetail b where b.booking.id=?1")
    void deleteByBookingId(int id);

}
