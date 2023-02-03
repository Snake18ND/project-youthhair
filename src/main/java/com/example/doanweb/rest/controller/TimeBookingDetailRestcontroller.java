package com.example.doanweb.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.doanweb.dao.TimeBookingDetailDAO;
import com.example.doanweb.entity.TimeBookingDetail;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/rest/getAllTimeBookingDetail")
public class TimeBookingDetailRestcontroller {
    @Autowired
    TimeBookingDetailDAO timeBookingDetailDAO;
    @GetMapping
    public List<TimeBookingDetail> getAllTimeBookingDetail(){
        return timeBookingDetailDAO.findAll();
    }

    @GetMapping("/getCheckTimeBooking")
    public List<TimeBookingDetail> getCheckTimeBookingDetail(Integer cid, Date date, Integer bookingId){
        return timeBookingDetailDAO.getCheckTimebooking(cid,date,bookingId);
    }


}
