package com.example.doanweb.service;

import java.util.Date;
import java.util.List;

import com.example.doanweb.entity.Employee;
import com.example.doanweb.entity.Voucher;
import com.example.doanweb.entity.Voucherdetail;
import com.example.doanweb.entity.Workassign;
import com.example.doanweb.service.dto.ShiftByEmployeeDTO;
import com.example.doanweb.service.dto.VoucherDetailInfoDTO;
import com.example.doanweb.service.dto.WorkassignDateDTO;

public interface WorkassignService {
	
	List<Workassign> findAll();

	Workassign save(Workassign workassign);

	List<Workassign> checkWorkassignNull(Integer id);

	List<WorkassignDateDTO> disctinctDate();

	List<Workassign> findWorkassignStylist(Date date);

	Workassign selectShiftByEmployeeId(Integer id, Date date);

	List<Workassign> findWorkassignAllStylist();
}
