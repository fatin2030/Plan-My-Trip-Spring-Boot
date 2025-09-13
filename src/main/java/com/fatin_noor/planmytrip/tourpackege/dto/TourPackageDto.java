package com.fatin_noor.planmytrip.tourpackege.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TourPackageDto {
    private Long id;
    private String tourPackageName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;


}
