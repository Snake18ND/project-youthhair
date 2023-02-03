package com.example.doanweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the services database table.
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="dichVuHot")
public class DichVuHot implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image")
    private String image;

    @Column(name = "note")
    private String note;

    @Column(name = "price")
    private float price;

    @Column(name = "serviceName")
    private String serviceName;

    private Boolean status;


}