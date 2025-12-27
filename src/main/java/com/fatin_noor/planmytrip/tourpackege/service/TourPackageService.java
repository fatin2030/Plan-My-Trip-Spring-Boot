package com.fatin_noor.planmytrip.tourpackege.service;
import com.fatin_noor.planmytrip.tourPackageInfo.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tourPackageInfo.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.tourpackege.repository.TourPackageRepository;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TourPackageService {

    void registerTourPackage(RegisterTourPackageDTO registerTourPackageDTO);


    void updateTourPackage(Long tourPackageId, TourPackageUpdateDTO tourPackageUpdateDTO);


    void deleteTourPackage(Long id );

    List<RegisterTourPackageDTO> searchTourPackage(String tourPackageName);

    List<RegisterTourPackageDTO> getAllTourPackages();

    TourPackageRepository.TourPackageProjection getTourPackageById(Long id);

    Page<TourPackageRepository.TourPackageProjection> getPaginatedTourPackages(int page, int size);
}
