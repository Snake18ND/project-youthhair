package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.doanweb.entity.Account;
import com.example.doanweb.entity.TimeBookingDetail;

import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import java.sql.Date;
import java.util.List;

public interface TimeBookingDetailDAO extends JpaRepository<TimeBookingDetail, Integer> {

//    @Query(value = "SELECT b FROM TimeBookingDetail b WHERE b.username = ?1")
//    Account findByName(String username);

      @Query(value = "SELECT b from TimeBookingDetail b where (b.stylistId=:styId) and (b.date=:date) and (b.bookingId <>:bookingId)")
      List<TimeBookingDetail> getCheckTimebooking(@Param("styId") Integer id, @Param("date") Date date , @Param("bookingId") Integer bookingId);

      @Transactional
      @Modifying
      @Query(value = "DELETE FROM TimeBookingDetail t WHERE t.bookingId=?1 ")
      void delete(int id);


}
