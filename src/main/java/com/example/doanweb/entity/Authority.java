package com.example.doanweb.entity;

import java.io.Serializable;
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
@Table(name = "authorities")
@NamedQuery(name = "Authority.findAll", query = "SELECT a FROM Authority a")
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="RoleId")
    private Role roleId;

    @ManyToOne
    @JoinColumn(name="Username")
    private Account account;

}