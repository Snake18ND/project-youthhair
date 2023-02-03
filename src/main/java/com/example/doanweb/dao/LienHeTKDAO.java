package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.doanweb.entity.LienHeTK;

public interface LienHeTKDAO extends JpaRepository<LienHeTK,String> {
    @Query(value = "SELECT count(lh.phone)  from LienHeTK lh where (:monthYear is null or lh.monthYear = :monthYear)")
    Integer countLienHeTK (@Param("monthYear") String monthYear);

    @Query(value = "SELECT lh from LienHeTK lh where (:monthYear is null or lh.monthYear = :monthYear)")
    LienHeTK getLienHeTK (@Param("monthYear") String monthYear);
}
