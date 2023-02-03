package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.doanweb.entity.Account;
import com.example.doanweb.entity.Shifts;
import com.example.doanweb.entity.TimeBooking;

import java.util.List;

public interface TimeBookingDAO extends JpaRepository<TimeBooking, Integer> {
    @Query(value = "SELECT b FROM TimeBooking b  WHERE b.shifts.id = ?1 ")
    List<TimeBooking> getTimeBookingByShift(Integer id);


}
