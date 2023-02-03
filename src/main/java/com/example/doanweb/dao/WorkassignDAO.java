package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.doanweb.entity.Employee;
import com.example.doanweb.entity.Services;
import com.example.doanweb.entity.Workassign;

import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;

public interface WorkassignDAO extends JpaRepository<Workassign, Integer> {

	@Query("SELECT w FROM Workassign w WHERE w.employee.id = :employeeId")
	List<Workassign> checkWorkassignNull(@Param("employeeId") Integer id);
	
	@Query("SELECT distinct (w.date) FROM Workassign w")
	List<Tuple> disctinctDate();

	@Query("SELECT w FROM Workassign w WHERE w.date = ?1  AND w.employee.role.id = 2 AND w.employee.statusWork = true")
	List<Workassign> findWorkassignStylist(Date date);

	@Query(value = "SELECT s FROM Workassign s WHERE s.employee.id = :id and s.date = :date")
	Workassign selectShiftByEmployeeId(@Param("id") Integer id,@Param("date") Date date);

	@Query("SELECT w FROM Workassign w WHERE w.employee.role.id = 2 ")
	List<Workassign> findWorkassignAllStylist();
    
}
