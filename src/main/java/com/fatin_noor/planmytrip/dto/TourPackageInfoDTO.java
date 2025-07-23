package com.fatin_noor.planmytrip.dto;

import lombok.Data;

@Data
public class TourPackageInfoDTO {
    private Long tourCategoryId;
    private String category;

    private int allowedPerson;

    private float price;

    private int availableSeats;

}
