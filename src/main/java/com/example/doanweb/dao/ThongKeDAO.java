package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.doanweb.entity.ThongKeDT;

@Repository
public interface ThongKeDAO extends JpaRepository<ThongKeDT,String> {
    @Query(value = "SELECT SUM (t.doanhThu) from ThongKeDT t where (t.monthYear is null or t.monthYear = :monthYear)")
    float doanhThuByMonth(@Param("monthYear") String monthYear);

    @Query(value = "SELECT tk from ThongKeDT tk where (:monthYear is null or tk.monthYear = :monthYear)")
    ThongKeDT thongKeDT(@Param("monthYear") String monthYear);
    
    @Query(value = "SELECT COUNT (t.doanhThu) from ThongKeDT t where (t.monthYear is null or t.monthYear = :monthYear)")
	float thongKeLichHenCPM(String monthYear);

    @Query(value = "SELECT COUNT (t) from ThongKeHD t where (t.monthYear is null or t.monthYear = :monthYear)")
	float thongKeLichHenAll(String monthYear);
}
