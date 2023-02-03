package com.example.doanweb.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.*;
import com.example.doanweb.entity.*;
import com.example.doanweb.service.WorkassignService;
import com.example.doanweb.service.dto.*;

@Service
public class WorkassignServiceImpl implements WorkassignService{

	@Autowired
	WorkassignDAO workassignDAO;

	@Override
	public List<Workassign> findAll() {
		return workassignDAO.findAll();
	}

	@Override
	public Workassign save(Workassign workassign) {
		return workassignDAO.save(workassign);
	}

	@Override
	public List<Workassign> checkWorkassignNull(Integer id) {
		return workassignDAO.checkWorkassignNull(id);
	}

	
	public List<WorkassignDateDTO> disctinctDate() {
		List<Tuple> stockDateTuples = workassignDAO.disctinctDate();
		List<WorkassignDateDTO> stockTotalDto = stockDateTuples.stream()
				.map(t -> new WorkassignDateDTO(
						t.get(0, Date.class)
				))
				.collect(Collectors.toList());
		
		return stockTotalDto;
	}

	@Override
	public List<Workassign> findWorkassignStylist(Date date) {
		return workassignDAO.findWorkassignStylist(date);
	}

	public Workassign selectShiftByEmployeeId(Integer id, Date date){
		return workassignDAO.selectShiftByEmployeeId(id,date);
	}
	@Override
	public List<Workassign> findWorkassignAllStylist() {
		return workassignDAO.findWorkassignAllStylist();
	}

	
}
