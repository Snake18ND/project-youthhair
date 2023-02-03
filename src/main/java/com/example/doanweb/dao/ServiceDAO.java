package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.doanweb.entity.Services;

import java.util.List;

public interface ServiceDAO extends JpaRepository<Services, Integer> {
    @Query(value = "SELECT s FROM Services s WHERE s.id =?1")
    Services selectById(Integer id);

    @Query(value = "SELECT s FROM Services s WHERE s.serviceName is null or s.serviceName like %:serviceName% ")
    List<Services> seachSericesByName(@Param("serviceName") String serviceName);

    @Query(value = "SELECT s FROM Services s WHERE s.status = true")
	List<Services> findServicesActive();
    
    @Query(value = "SELECT  s FROM Services s WHERE s.status = true")
	List<Services> findServicesActiveTop3();
}
