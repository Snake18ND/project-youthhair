package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import com.example.doanweb.entity.Voucher;
import com.example.doanweb.entity.Voucherdetail;
import com.example.doanweb.service.dto.VoucherDetailInfoDTO;

import java.util.List;

public interface VoucherDetailDAO extends JpaRepository<Voucherdetail, Integer> {
    @Query(value = "SELECT v FROM Voucherdetail vd join Voucher v on vd.voucher.id = v.id  where vd.customer.id = ?1 and vd.status = true ")
    List<Voucher> selectVoucherByCus(Integer id);

    @Query(value = "SELECT vd FROM Voucherdetail vd where vd.voucher.id like ?1 and vd.status = true ")
    Voucherdetail selectVoucherDetailByCus(String id);
}
