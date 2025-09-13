package com.fatin_noor.planmytrip.tourpackege.service;
import com.fatin_noor.planmytrip.tourpackege.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.TourPackageUpdateDTO;

import java.util.List;

public interface TourPackageService {

    void registerTourPackage(RegisterTourPackageDTO registerTourPackageDTO);
    void addTourPackageInfo(Long id, AddTourPackageInfoDTO addTourPackageInfoDTO);

    void updateTourPackage(Long tourPackageId, TourPackageUpdateDTO tourPackageUpdateDTO);

    void updateTourPackageInfo(Long id , TourPackageInfoDTO tourPackageInfoDTO);

    void deleteTourPackage(Long id );

    List<RegisterTourPackageDTO> searchTourPackage(String tourPackageName);

    List<RegisterTourPackageDTO> getAllTourPackages();
}
