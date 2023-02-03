package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the bookingdetails database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bookingdetails")
@NamedQuery(name="BookingDetail.findAll", query="SELECT b FROM BookingDetail b")
public class BookingDetail implements Serializable {
	private static final long serialVersionUID = 1L;
//	@EmbeddedId
//	private BookingDetailPK id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private float price;

//	@NotNull
//	private Time time;

	//bi-directional many-to-one association to Booking
	@ManyToOne
	@JoinColumn(name="BookingId")
	private Booking booking;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="ServiceId")
	private Services service;
}