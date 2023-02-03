package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String email;

	private String fullName;

	private String phone;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Booking> bookings;

	//bi-directional many-to-one association to Contact
//	@OneToMany(mappedBy="customer")
//	@JsonIgnore
//	private List<Contact> contacts;

	//bi-directional many-to-one association to Voucherdetail
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Voucherdetail> voucherdetails;

	
}