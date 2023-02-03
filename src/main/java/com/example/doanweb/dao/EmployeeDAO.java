package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.doanweb.entity.Employee;
import com.example.doanweb.service.dto.StylistDTO;

import javax.persistence.Tuple;
import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT b FROM Employee b WHERE b.id= ?1")
    Employee employeeByIdStylist(Integer StylistId);

    @Query(value = "SELECT b FROM Employee b WHERE b.role.id= 2 and  b.statusWork = true")
    List<Employee> bookingByStylist();

    @Query(value = "SELECT distinct(e.id),e.fullName,e.image, b.statusbooking.id  " +
            "FROM Employee e left join Booking b on e.id = b.employee1.id where e.statusWork = true and e.role.id=2")
    List<Tuple> getAllStylistST();

    @Query(value = "SELECT e FROM Employee e WHERE :fullName is null or e.fullName like %:fullName% AND e.statusWork= true")
    List<Employee> seachEmployee(@Param("fullName") String fullName);
    
    @Query(value = "SELECT e FROM Employee e WHERE e.statusWork= true")
	List<Employee> getAllEmployeeActive();

    @Query(value = "SELECT count(e) FROM Employee e")
    Integer countNv();

    @Query(value = "SELECT count(e) FROM Employee e where e.role = 2")
    Integer countStyList();
}
