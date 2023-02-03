package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private String timeBooking;
	
	private String note;

//	private int stylistId;

	private float totalPrice;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CustormerId")
	private Customer customer;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="StylistId")
	private Employee employee1;

	//bi-directional many-to-one association to Statusbooking
	@ManyToOne
	@JoinColumn(name="StatusId")
	private Statusbooking statusbooking;

	//bi-directional one-to-one association to Employee
//	@OneToOne
//	@JoinColumn(name="Id")
//	@JsonIgnore
//	private Employee employee2;

	//bi-directional many-to-one association to Voting
	@ManyToOne
	@JoinColumn(name="VotingId")
	private Voting voting;
	
	//bi-directional many-to-one association to VoucherDetails
	@ManyToOne
	@JoinColumn(name="VoucherDetailsId")
	private Voucherdetail voucherdetails;

	//bi-directional many-to-one association to Bookingdetail
	@OneToMany(mappedBy="booking")
	@JsonIgnore
	private List<BookingDetail> bookingdetails;


}