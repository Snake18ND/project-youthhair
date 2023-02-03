package com.example.doanweb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the accounts database table.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workassign")
@NamedQuery(name = "Workassign.findAll", query = "SELECT w FROM Workassign w")
public class Workassign implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name="employees_Id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="shifts_Id")
    private Shifts shifts;

}