package com.example.doanweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="thongbaoucf")
//@NamedQuery(name="Service.findAll", query="SELECT dt FROM ThongKeDT dt")
public class ThongBaoUCF implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    private Integer Id;

    @Temporal(TemporalType.DATE)
	private Date createDate;
	
	private String timeBooking;
	
	@ManyToOne
	@JoinColumn(name="StylistId")
	private Employee stylist;
	
	@ManyToOne
	@JoinColumn(name="CustormerId")
	private Customer customer;
}
