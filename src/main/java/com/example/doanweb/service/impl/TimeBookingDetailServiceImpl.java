package com.example.doanweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.doanweb.dao.TimeBookingDetailDAO;
import com.example.doanweb.service.TimeBookingDetailService;

@Service
public class TimeBookingDetailServiceImpl implements TimeBookingDetailService {
    @Autowired
    TimeBookingDetailDAO timeBookingDetailDAO;

    @Override
    public void deleteByBookingId(int id) {
        timeBookingDetailDAO.delete(id);
    }
}
