package com.example.fatin_noor.PlanMyTrip.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TourPackageUpdateDTO {

    private String tourPackageName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<TourPackageInfoDTO> tourPackageInfoList;
}
