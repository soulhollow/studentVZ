package com.example.verbindung.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "useraccounts", schema = "StudentVZ") //ändern auf unser werte
public class UserAccountEntity {


    @Id
    @Column(name = "idUserAccount", nullable = false)
    private Long id;

    @Column(name = "userMail")
    private String userMail;
    @Column(name = "password")
    private String password;
    @Column(name = "profileName")
    private String profileName;



}
