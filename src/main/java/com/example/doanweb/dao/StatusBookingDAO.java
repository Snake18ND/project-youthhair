package com.example.doanweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import com.example.doanweb.entity.Statusbooking;

public interface StatusBookingDAO extends JpaRepository<Statusbooking, String> {
    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'UCF' ")
    Statusbooking StatusbookingbyId();

    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'CPM' ")
    Statusbooking StatusbookingbyIdCPM();

    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'WFC' ")
    Statusbooking StatusbookingbyIdWFC();

    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'CAN'")
    Statusbooking StatusBookigByIdCAN();

    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'COM'")
    Statusbooking StatusBookigByIdCOM();

    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'IAT' ")
    Statusbooking StatusbookingbyIdIAT();
}
