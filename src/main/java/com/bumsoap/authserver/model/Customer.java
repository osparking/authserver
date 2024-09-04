package com.bumsoap.authserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter @Setter
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String mobileNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    @JsonIgnore
    private Date createDt;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Authority> authorities;
}
