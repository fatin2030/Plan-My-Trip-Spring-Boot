package com.fatin_noor.planmytrip.user.dto;


import lombok.Data;

@Data
public class AddressDTO {
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String houseNo;
    private String description;

}
