package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
@Access(AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_NAME")
    private String name;
    @Column(name = "USER_EMAIL")
    private String email;
    @Column(name = "USER_ADRESS")
    private String address;
    @Column(name = "USER_LOGIN")
    private String userLogin;
    @Column(name = "USER_STATUS")
    private boolean userStatus;
    @Column(name = "USER_PASSWORD")
    private String password;
}