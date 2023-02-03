package com.example.doanweb.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StylistDTO {
    private Integer id;
    private String fullName;
    private String image;
    private String statusBooking;
}
