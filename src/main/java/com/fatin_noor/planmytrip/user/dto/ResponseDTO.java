package com.fatin_noor.planmytrip.user.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String name;
    private String email;
    private AddressDTO address;
    private RoleDTO role;
}
