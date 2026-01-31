package com.fatin_noor.planmytrip.tour_package_info.service.impl;

import com.fatin_noor.planmytrip.mapper.TourPackageMapper;
import com.fatin_noor.planmytrip.tour_package_info.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_package_info.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_package_info.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.tour_package_info.repository.TourPackageInfoRepository;
import com.fatin_noor.planmytrip.tour_package_info.service.TourPackageInfoService;
import com.fatin_noor.planmytrip.tour_packege.entity.TourPackages;
import com.fatin_noor.planmytrip.tour_packege.repository.TourPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourPackageInfoServiceImpl implements TourPackageInfoService {
    private final TourPackageInfoRepository tourPackageInfoRepository;
    private final TourPackageRepository tourPackagesRepository;
    private final TourPackageMapper tourPackageMapper;






    public void addTourPackageInfo(AddTourPackageInfoDTO addTourPackageInfoDTO) {

        List<TourPackageInfo> tourPackageInfos = addTourPackageInfoDTO.getTourPackageInfoList().stream().map(tourPackageMapper::toEntity).toList();
        tourPackageInfoRepository.saveAll(tourPackageInfos);

    }


    public void updateTourPackageInfo(Long id, TourPackageInfoDTO tourPackageInfoDTO) {

        TourPackageInfo tourPackageInfo = tourPackageInfoRepository.findById(id)
                .orElseThrow(()
                        -> new IllegalArgumentException(" Tour Package Not Found"));

        if (tourPackageInfoDTO.getAvailableSeats() > 0) {
            tourPackageInfo.setAvailableSeats(tourPackageInfoDTO.getAvailableSeats());
        }
        if (tourPackageInfoDTO.getCategory() != null) {
            tourPackageInfo.setCategory(tourPackageInfoDTO.getCategory());
        }
        if (tourPackageInfoDTO.getPrice() > 0) {
            tourPackageInfo.setPrice(tourPackageInfoDTO.getPrice());
        }
        if (tourPackageInfoDTO.getAllowedPerson() > 0) {
            tourPackageInfo.setAllowedPerson(tourPackageInfoDTO.getAllowedPerson());
        }

        tourPackageInfoRepository.save(tourPackageInfo);

    }



}

