package com.fatin_noor.planmytrip.tourpackege.dto;


import lombok.Data;

import java.util.List;

@Data
public class AddTourPackageInfoDTO {
    private List<TourPackageInfoDTO> tourPackageInfoList;
}
