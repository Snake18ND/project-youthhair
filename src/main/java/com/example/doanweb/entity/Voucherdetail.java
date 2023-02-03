package com.example.doanweb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the voucherdetail database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Voucherdetail.findAll", query="SELECT v FROM Voucherdetail v")
public class Voucherdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean status;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CustomerId")
	private Customer customer;

	//bi-directional many-to-one association to Voucher
	@ManyToOne
	@JoinColumn(name="VoucherId")
	private Voucher voucher;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="voucherdetails")
	@JsonIgnore
	private List<Booking> bookings;

}