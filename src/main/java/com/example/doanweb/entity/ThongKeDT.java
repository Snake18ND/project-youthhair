package com.example.doanweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="thongKeDT")
//@NamedQuery(name="Service.findAll", query="SELECT dt FROM ThongKeDT dt")
public class ThongKeDT implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "monthYear")
    private String monthYear;

    @Column(name= "doanhThu")
    private float doanhThu;


}
