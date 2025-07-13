package com.example.fatin_noor.PlanMyTrip.dto;


import lombok.Data;

import java.util.List;

@Data
public class AddTourPackageInfoDTO {
    private List<TourPackageInfoDTO> tourPackageInfoList;
}
