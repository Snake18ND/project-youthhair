package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shifts")
@NamedQuery(name="Shifts.findAll", query="SELECT s FROM Shifts s")
public class Shifts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="shifts")
	@JsonIgnore
	private List<Workassign> workassign;

	@OneToMany(mappedBy="shifts")
	@JsonIgnore
	private List<TimeBooking> TimeBooking;



}