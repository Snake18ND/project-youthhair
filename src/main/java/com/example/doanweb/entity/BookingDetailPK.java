package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The primary key class for the bookingdetails database table.
 * 
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer bookingId;

	@Column(insertable=false, updatable=false)
	private Integer serviceId;

	
	

}
