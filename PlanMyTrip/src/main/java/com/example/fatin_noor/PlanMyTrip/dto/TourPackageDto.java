package com.example.fatin_noor.PlanMyTrip.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TourPackageDto {
    private String tourPackageName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;


}
