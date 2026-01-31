package com.fatin_noor.planmytrip.tour_package_info.dto;


import lombok.Data;

import java.util.List;

@Data
public class AddTourPackageInfoDTO {
    private List<TourPackageInfoDTO> tourPackageInfoList;
}
