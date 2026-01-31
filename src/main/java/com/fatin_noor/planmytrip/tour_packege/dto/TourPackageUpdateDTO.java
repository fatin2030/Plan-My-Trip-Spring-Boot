package com.fatin_noor.planmytrip.tour_packege.dto;


import com.fatin_noor.planmytrip.tour_package_info.dto.TourPackageInfoDTO;
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
