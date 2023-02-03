package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.doanweb.entity.DichVuHot;

import java.util.List;

public interface DichVuHotDAO extends JpaRepository<DichVuHot,Integer> {
    @Query(value = "SELECT  s FROM DichVuHot s WHERE s.status = true")
    List<DichVuHot> findServicesActiveTop3();
}
