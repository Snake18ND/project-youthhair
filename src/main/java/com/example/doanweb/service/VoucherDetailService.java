package com.example.doanweb.service;

import java.util.List;

import com.example.doanweb.entity.Voucher;
import com.example.doanweb.entity.Voucherdetail;
import com.example.doanweb.service.dto.VoucherDetailInfoDTO;

public interface VoucherDetailService {
	
	List<Voucherdetail> findAll();

    List<Voucher> VoucherByCus(Integer id);
    VoucherDetailInfoDTO completeBooking(VoucherDetailInfoDTO voucherDetailInfoDTO );

	Voucherdetail save(Voucherdetail voucherDetail);
}
