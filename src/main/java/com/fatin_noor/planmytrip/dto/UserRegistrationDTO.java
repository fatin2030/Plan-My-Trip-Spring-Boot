package com.fatin_noor.planmytrip.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
public class UserRegistrationDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank (message = "Country is required")
    private String country;

    @NotBlank (message = "City is required")
    private String city;

    @NotBlank (message = "Street is required")
    private String street;


    @NotBlank(message = "Role Name is required")
    private String roleName;

}
