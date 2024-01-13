package com.BjjEvent.Test.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "atletas")
@Data
public class Atleta {

    @Id
    @Column(name = "dni")
    private int dni;

    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "province")
    private String province; //optional null

    @Column(name = "city")
    private String city; //optional null

    @Column(name = "gender")
    private String gender;

    @Column(name = "belt")
    private String belt;

    @Column(name = "degrees")
    private String degrees; //optional null

    @Column(name = "category_age")
    private String category_age;

    @Column(name = "category_weight")
    private String category_weight;

    @Column(name = "modality")
    private String modality;

    @Column(name = "absolute")
    private String absolute; //optional null

    @Column(name = "academy")
    private String academy;

}
