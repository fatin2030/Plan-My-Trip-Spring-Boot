package com.fatin_noor.planmytrip.service;

import com.fatin_noor.planmytrip.dto.*;
import com.fatin_noor.planmytrip.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.dto.TourPackageUpdateDTO;

import java.util.List;

public interface TourPackageService {

    RegisterTourPackageDTO registerTourPackage(RegisterTourPackageDTO registerTourPackageDTO);
    List<TourPackageInfoDTO> addTourPackageInfo(Long id, AddTourPackageInfoDTO addTourPackageInfoDTO);

    TourPackageUpdateDTO updateTourPackage(Long tourPackageId, TourPackageUpdateDTO tourPackageUpdateDTO);

    TourPackageInfoDTO updateTourPackageInfo(Long id , TourPackageInfoDTO tourPackageInfoDTO);

    String deleteTourPackage(Long id );

    List<RegisterTourPackageDTO> searchTourPackage(String tourPackageName);
}
