package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the statusbooking database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Statusbooking.findAll", query="SELECT s FROM Statusbooking s")
public class Statusbooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String statusName;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="statusbooking")
	@JsonIgnore
	private List<Booking> bookings;

}