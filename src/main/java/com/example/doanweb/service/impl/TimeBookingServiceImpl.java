package com.example.doanweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.doanweb.dao.TimeBookingDAO;
import com.example.doanweb.entity.TimeBooking;
import com.example.doanweb.service.TimeBookingService;

import java.util.List;

@Service
public class TimeBookingServiceImpl implements TimeBookingService {

    @Autowired
    TimeBookingDAO timeBookingDAO;

    public List<TimeBooking> getTimeByShifts(Integer id){

        return timeBookingDAO.getTimeBookingByShift(id);
}
}
