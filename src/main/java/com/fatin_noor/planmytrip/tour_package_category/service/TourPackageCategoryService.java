package com.fatin_noor.planmytrip.tour_package_category.service;

import com.fatin_noor.planmytrip.tour_package_category.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_package_category.dto.TourPackageInfoDTO;

public interface TourPackageCategoryService {
    void addTourPackageInfo(AddTourPackageInfoDTO addTourPackageInfoDTO);
    void updateTourPackageInfo(Long id , TourPackageInfoDTO tourPackageInfoDTO);


}
