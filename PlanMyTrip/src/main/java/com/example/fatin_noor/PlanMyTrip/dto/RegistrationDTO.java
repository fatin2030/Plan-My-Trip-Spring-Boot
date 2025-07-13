package com.example.fatin_noor.PlanMyTrip.dto;


import lombok.*;


@Data
public class RegistrationDTO {

    private String name;
    private String email;

    private String country;
    private String city;
    private String street;

    // Role name
    private String roleName;

}
