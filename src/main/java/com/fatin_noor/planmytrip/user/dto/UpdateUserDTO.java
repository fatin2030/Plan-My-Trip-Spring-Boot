package com.fatin_noor.planmytrip.user.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
@Data


public class UpdateUserDTO {

    private String name;

    @Email
    private String email;

    private String country;

    private String city;

    private String street;
}
