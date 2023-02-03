package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the services database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="services")
@NamedQuery(name="Service.findAll", query="SELECT s FROM Services s")
public class Services implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String image;

	private String note;

	private float price;

	private String serviceName;

	private Boolean status;

	//bi-directional many-to-one association to Bookingdetail
	@OneToMany(mappedBy="service")
	@JsonIgnore
	private List<BookingDetail> bookingdetails;


}