package com.example.doanweb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "accounts")
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;


    //	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private Integer id;
    @Id
    private String username;
    private String password;

    @OneToMany(mappedBy="account",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Authority> authorities;
}