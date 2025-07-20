package com.fatin_noor.planmytrip.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import lombok.Data;
@Data

@JsonIgnoreProperties(ignoreUnknown = false)

public class UpdateUserDTO {

    private String name;

    @Email
    private String email;

    private String country;

    private String city;

    private String street;
}
