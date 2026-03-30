package com.fatin_noor.planmytrip.company.dto;

import com.fatin_noor.planmytrip.user.dto.AddressDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyCreateDto {
    @NotEmpty(message = "Company name must not be empty")
    private String companyName;

    @NotEmpty(message = "Trade License Number must not be empty")
    private String tradeLicenseNo;

    @NotEmpty(message = "Email must not be empty")
    private String email;

    @NotEmpty(message = "Phone number must not be empty")
    private String phoneNumber;

    @NotNull(message = "Address is mandatory")
    private AddressDTO address;
}
