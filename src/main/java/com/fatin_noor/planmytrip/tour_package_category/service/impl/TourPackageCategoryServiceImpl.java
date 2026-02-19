package com.fatin_noor.planmytrip.tour_package_category.service.impl;

import com.fatin_noor.planmytrip.mapper.TourPackageMapper;
import com.fatin_noor.planmytrip.tour_package_category.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_package_category.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_package_category.entity.TourPackageCategory;
import com.fatin_noor.planmytrip.tour_package_category.repository.TourPackageInfoRepository;
import com.fatin_noor.planmytrip.tour_package_category.service.TourPackageCategoryService;
import com.fatin_noor.planmytrip.tour_packege.repository.TourPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourPackageCategoryServiceImpl implements TourPackageCategoryService {
    private final TourPackageInfoRepository tourPackageInfoRepository;
    private final TourPackageRepository tourPackagesRepository;
    private final TourPackageMapper tourPackageMapper;






    public void addTourPackageInfo(AddTourPackageInfoDTO addTourPackageInfoDTO) {

        List<TourPackageCategory> tourPackageCategories = addTourPackageInfoDTO.getTourPackageInfoList().stream().map(tourPackageMapper::toEntity).toList();
        tourPackageInfoRepository.saveAll(tourPackageCategories);

    }


    public void updateTourPackageInfo(Long id, TourPackageInfoDTO tourPackageInfoDTO) {

        TourPackageCategory tourPackageCategory = tourPackageInfoRepository.findById(id)
                .orElseThrow(()
                        -> new IllegalArgumentException(" Tour Package Not Found"));

        tourPackageInfoRepository.save(tourPackageCategory);

    }



}

