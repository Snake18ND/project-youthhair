package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * The persistent class for the contacts database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="contacts")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private String email;

	private String fullName;

	private String note;

	private String phone;

	private Boolean status;

	public Contact(Date createDate, String email, String fullName, String note, String phone, Boolean status) {
		super();
		this.createDate = createDate;
		this.email = email;
		this.fullName = fullName;
		this.note = note;
		this.phone = phone;
		this.status = status;
	}

	
	
	//bi-directional many-to-one association to Customer
//	@ManyToOne
//	@JoinColumn(name="CustomerId")
//	@JsonIgnore
//	private Customer customer;


}