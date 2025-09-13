package com.fatin_noor.planmytrip.tourpackege.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RegisterTourPackageDTO {

    private Long id;
    @NotBlank(message = "Tour package name is required")
    private String tourPackageName;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    @NotNull(message = "End date is required")
    private LocalDate endDate;


    @NotEmpty(message = "At least one tour package info is required")
    private List<TourPackageInfoDTO> tourPackageInfoList;
}
