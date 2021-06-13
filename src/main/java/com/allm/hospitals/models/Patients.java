package com.allm.hospitals.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "patients")
public class Patients {

    @Id
    @Column(name = "patient_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private  String password;

}
