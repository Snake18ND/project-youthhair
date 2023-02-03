package com.example.doanweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.*;
import com.example.doanweb.entity.*;
import com.example.doanweb.service.ShiftsService;
import com.example.doanweb.service.VoucherDetailService;
import com.example.doanweb.service.WorkassignService;
import com.example.doanweb.service.dto.BookingCustomerDTO;
import com.example.doanweb.service.dto.VoucherDetailInfoDTO;

@Service
public class ShiftsServiceImpl implements ShiftsService{

	@Autowired
	ShiftsDAO shiftsDAO;

	@Override
	public List<Shifts> findAll() {
		return shiftsDAO.findAll();
	}

	@Override
	public Shifts save(Shifts shifts) {
		return shiftsDAO.save(shifts);
	}

	
}
