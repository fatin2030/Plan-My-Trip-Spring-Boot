package com.fatin_noor.planmytrip.tour_package_info.service;

import com.fatin_noor.planmytrip.tour_package_info.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_package_info.dto.TourPackageInfoDTO;

public interface TourPackageInfoService {
    void addTourPackageInfo(AddTourPackageInfoDTO addTourPackageInfoDTO);
    void updateTourPackageInfo(Long id , TourPackageInfoDTO tourPackageInfoDTO);


}
