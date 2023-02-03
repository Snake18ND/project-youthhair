package com.example.doanweb.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.doanweb.entity.Services;

import java.sql.Time;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingContactDTO {

	//Customer

	private String email;

	private String fullName;

	private String phone;

	//booking
	
	private String time;
	
	private Date createDate;

	private String note;

	private int stylistId;

	private float totalPrice;

	//Service
	private List<Services> listSer;

}
