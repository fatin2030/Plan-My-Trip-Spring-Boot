package com.fatin_noor.planmytrip.tourPackageInfo.service.impl;

import com.fatin_noor.planmytrip.mapper.TourPackageMapper;
import com.fatin_noor.planmytrip.tourPackageInfo.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourPackageInfo.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourPackageInfo.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.tourPackageInfo.repository.TourPackageInfoRepository;
import com.fatin_noor.planmytrip.tourPackageInfo.service.TourPackageInfoService;
import com.fatin_noor.planmytrip.tourpackege.entity.TourPackages;
import com.fatin_noor.planmytrip.tourpackege.repository.TourPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourPackageInfoServiceImpl implements TourPackageInfoService {
    private final TourPackageInfoRepository tourPackageInfoRepository;
    private final TourPackageRepository tourPackagesRepository;
    private final TourPackageMapper tourPackageMapper;






    public void addTourPackageInfo(Long id, AddTourPackageInfoDTO addTourPackageInfoDTO) {
        TourPackages tourPackage = tourPackagesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tour Package Not Found"));

        List<TourPackageInfo> tourPackageInfos = addTourPackageInfoDTO.getTourPackageInfoList().stream().map(infoDto -> {
            TourPackageInfo tourInfo = tourPackageMapper.toEntity(infoDto);
            tourInfo.setTourPackages(tourPackage);
            return tourInfo;
        }).toList();
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

