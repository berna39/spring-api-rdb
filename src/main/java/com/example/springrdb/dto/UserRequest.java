package com.example.springrdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    private int id;
    @NotNull(message = "Plz entrer the name")
    private String name;
    @NotNull(message = "Plz entrer the email")
    private String email;
    @NotNull(message = "Plz entrer the phone")
    private String phone;
    @NotNull(message = "Plz entrer the gender")
    private String gender;
    @Min(10)
    @Max(100)
    private int age;
    @NotNull(message = "Plz entrer the nationality")
    private String nationality;
}
