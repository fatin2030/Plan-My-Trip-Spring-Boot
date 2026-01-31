package com.fatin_noor.planmytrip.tour_package_info.dto;

import lombok.Data;

@Data
public class TourPackageInfoDTO {
    private Long tourCategoryId;
    private String category;

    private int allowedPerson;

    private float price;

    private int availableSeats;

}
