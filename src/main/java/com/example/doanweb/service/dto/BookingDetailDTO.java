package com.example.doanweb.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.doanweb.entity.Services;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailDTO {

	private List<Services> listSer ;
	
}
