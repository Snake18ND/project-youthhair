package com.example.doanweb.service;

import java.util.List;

import com.example.doanweb.entity.Shifts;

public interface ShiftsService {
	
	List<Shifts> findAll();

	Shifts save(Shifts shifts);

}
