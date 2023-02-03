package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.doanweb.entity.Booking;
import com.example.doanweb.entity.Employee;
import com.example.doanweb.entity.ThongBaoUCF;

import javax.persistence.Tuple;

import java.util.Date;
import java.util.List;

public interface BookingDAO extends JpaRepository<Booking, Integer> {


    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = ?1")
    List<Booking> bookingByStatus(String status);

    @Query(value = "SELECT e.fullName FROM Employee e")
    String[] finbyEmployee();

    @Query(value = "SELECT b.name FROM TimeBooking b")
    String[] findByTimeBooking();

    @Query(value = "SELECT e FROM Employee e where e.role.id=2 and e.statusWork=true ")
    List<Employee>  findByRoleAndSatus();

    @Query(value = "SELECT b from Booking b where b.statusbooking.id='WFC' AND b.employee1.role.id=2 and b.id=?1")
    List<Booking> findByStatusWFCAndStylist(int id);

    @Query(value = "SELECT b FROM Booking b  WHERE b.customer.id = :customer and b.statusbooking.id = 'UCF' ")
    Booking bookingByCustomer(@Param("customer") Integer customer );

    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'IAT' and b.employee1.id = ?1")
    Booking bookingCusByStylist(Integer id);

    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'WFP' and b.customer.id = ?1")
    Booking bookingCusByCusWFP(Integer id);

    @Query(value = "SELECT b.employee1.id FROM Booking b WHERE b.statusbooking.id = 'IAT' ")
    List<Tuple> bookingIAT();

    @Query(value = "SELECT b FROM Booking b WHERE b.customer.phone = ?1  and b.statusbooking.id='UCF' ")
    Booking checkBookingUCF(String phone);
    
    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'IAT' ORDER BY b.employee1.id ASC")
    List<Booking> getAllBookingIAT();

    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'IAT' AND b.employee1.id = ?1 ")
	Booking findBookingIATbyStylist(Integer id);
    
    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'WFC' AND b.employee1.id = ?1 AND b.createDate = ?2")
    List<Booking> findBookingWFCbyStylist(Integer id, Date date);

    @Query("SELECT b FROM Booking b WHERE (:toDate is null or b.createDate >= :toDate) " +
            "and (:formDate is null or b.createDate <= :formDate)" +
            "and (:statusId is null or b.statusbooking.id = :statusId)" +
            "and (:cusName is null or b.customer.fullName like :cusName%)")
    List<Booking> seachBooking(@Param("toDate") Date toDate, @Param("formDate") Date formDate, @Param("statusId") String statusId, @Param("cusName") String cusName);
    
    @Query(value = "SELECT b FROM Booking b  WHERE b.customer.id = :customer and b.statusbooking.id = 'WFC'")
    Booking findCustomerInBookingWFC(@Param("customer") Integer customer );

    @Query(value = "SELECT b FROM ThongBaoUCF b")
	List<ThongBaoUCF> alertBookingUCF();

}
