package com.example.fatin_noor.PlanMyTrip.service;

import com.example.fatin_noor.PlanMyTrip.dto.AddTourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.dto.RegisterTourPackageDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageUpdateDTO;

import java.util.List;

public interface TourPackageService {

    RegisterTourPackageDTO registerTourPackage(RegisterTourPackageDTO registerTourPackageDTO);
    List<TourPackageInfoDTO> addTourPackageInfo(Long id, AddTourPackageInfoDTO addTourPackageInfoDTO);

    TourPackageUpdateDTO updateTourPackage(Long tourPackageId, TourPackageUpdateDTO tourPackageUpdateDTO);

    TourPackageInfoDTO updateTourPackageInfo(Long id , TourPackageInfoDTO tourPackageInfoDTO);
}
