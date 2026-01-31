package com.fatin_noor.planmytrip.tour_packege.service;
import com.fatin_noor.planmytrip.tour_packege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tour_packege.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.tour_packege.repository.TourPackageRepository;
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
