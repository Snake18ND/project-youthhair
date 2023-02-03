package com.example.doanweb.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.doanweb.entity.TimeBooking;
import com.example.doanweb.service.TimeBookingService;

import java.util.List;

@RestController

public class TimeBookingRestController {

    @Autowired
    TimeBookingService timeBookingService;

    @GetMapping("/rest/getAllTimebyShift/{id}")
    public List<TimeBooking> getAllTime(@PathVariable("id") Integer id){
        return timeBookingService.getTimeByShifts(id);
    }
}
