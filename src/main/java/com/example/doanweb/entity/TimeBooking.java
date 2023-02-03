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
@Table(name="timebooking")
@NamedQuery(name="TimeBooking.findAll", query="SELECT tb FROM TimeBooking tb")
public class TimeBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="shifts_Id")
	private Shifts shifts;


}