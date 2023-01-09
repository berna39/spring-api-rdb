package com.example.springrdb.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserQuery {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private int age;
    private String nationality;
}
