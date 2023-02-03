package com.example.doanweb.service;

import com.example.doanweb.entity.TimeBooking;

import java.util.List;

public interface TimeBookingService {
    List<TimeBooking> getTimeByShifts(Integer id);
}
