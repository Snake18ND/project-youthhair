package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.doanweb.entity.Voucher;

import java.util.List;

public interface VoucherDAO extends JpaRepository<Voucher, String>{
    @Query(value = "SELECT v FROM Voucher v WHERE :id is null or v.id like %:id% ")
    List<Voucher> seachVoucher(@Param("id") String id);
}
