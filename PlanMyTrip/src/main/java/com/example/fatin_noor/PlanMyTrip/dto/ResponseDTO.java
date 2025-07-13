package com.example.fatin_noor.PlanMyTrip.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String name;
    private String email;
    private AddressDTO address;
    private RoleDTO role;
}
