package com.fatin_noor.planmytrip.tourPackageInfo.service;

import com.fatin_noor.planmytrip.tourPackageInfo.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourPackageInfo.dto.TourPackageInfoDTO;

public interface TourPackageInfoService {
    void addTourPackageInfo(Long id, AddTourPackageInfoDTO addTourPackageInfoDTO);
    void updateTourPackageInfo(Long id , TourPackageInfoDTO tourPackageInfoDTO);


}
