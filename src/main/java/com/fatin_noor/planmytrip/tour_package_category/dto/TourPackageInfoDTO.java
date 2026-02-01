package com.fatin_noor.planmytrip.tour_package_category.dto;

import lombok.Data;

@Data
public class TourPackageInfoDTO {
    private String category;

    private int allowedPerson;

    private float price;

    private int availableSeats;

}
