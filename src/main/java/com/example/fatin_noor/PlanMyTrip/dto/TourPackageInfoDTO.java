package com.example.fatin_noor.PlanMyTrip.dto;

import com.example.fatin_noor.PlanMyTrip.entity.TourPackageInfo;
import com.example.fatin_noor.PlanMyTrip.entity.TourPackages;
import lombok.Data;

import java.util.List;

@Data
public class TourPackageInfoDTO {
    private String category;

    private int allowedPerson;

    private float price;

    private int availableSeats;

}
