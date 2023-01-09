package com.example.springrdb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private int age;
    private String nationality;
}
