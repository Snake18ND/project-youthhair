package com.example.doanweb.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the vouchers database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vouchers")
@NamedQuery(name="Voucher.findAll", query="SELECT v FROM Voucher v")
public class Voucher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "`condition`")
	@NotNull
	@Min(10000)
	private float condition;

	@NotNull
	private String note;

	@NotNull
	@Min(10000)
	private float price;

	//bi-directional many-to-one association to Voucherdetail
	@OneToMany(mappedBy="voucher")
	@JsonIgnore
	private List<Voucherdetail> voucherdetails;


}