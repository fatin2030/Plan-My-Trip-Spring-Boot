package com.example.fatin_noor.PlanMyTrip.service;

import com.example.fatin_noor.PlanMyTrip.dto.*;

import java.util.List;

public interface TourPackageService {

    RegisterTourPackageDTO registerTourPackage(RegisterTourPackageDTO registerTourPackageDTO);
    List<TourPackageInfoDTO> addTourPackageInfo(Long id, AddTourPackageInfoDTO addTourPackageInfoDTO);

    TourPackageUpdateDTO updateTourPackage(Long tourPackageId, TourPackageUpdateDTO tourPackageUpdateDTO);

    TourPackageInfoDTO updateTourPackageInfo(Long id , TourPackageInfoDTO tourPackageInfoDTO);

    String deleteTourPackage(Long id );

    List<RegisterTourPackageDTO> searchTourPackage(String tourPackageName);
}
