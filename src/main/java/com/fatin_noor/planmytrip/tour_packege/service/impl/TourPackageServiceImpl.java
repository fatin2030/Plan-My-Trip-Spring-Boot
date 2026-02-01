package com.fatin_noor.planmytrip.tour_packege.service.impl;

import com.fatin_noor.planmytrip.tour_packege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tour_package_category.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_packege.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.tour_package_category.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.tour_packege.entity.TourPackages;
import com.fatin_noor.planmytrip.mapper.TourPackageMapper;
import com.fatin_noor.planmytrip.tour_package_category.repository.TourPackageInfoRepository;
import com.fatin_noor.planmytrip.tour_packege.repository.TourPackageRepository;
import com.fatin_noor.planmytrip.tour_packege.service.TourPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TourPackageServiceImpl implements TourPackageService {
    private final TourPackageRepository tourPackagesRepository;
    private final TourPackageInfoRepository tourPackageInfoRepository;
    private final TourPackageMapper tourPackageMapper;


    public void registerTourPackage(RegisterTourPackageDTO registerTourPackageDTO){


        TourPackages tourPackages = tourPackageMapper.toEntity(registerTourPackageDTO);

        if(!registerTourPackageDTO.getTourPackageInfoId().isEmpty()){
            List<TourPackageInfo> tourPackageInfo = tourPackageInfoRepository
                    .findByIdIn(registerTourPackageDTO.getTourPackageInfoId());
            if(tourPackageInfo.size() != registerTourPackageDTO.getTourPackageInfoId().size()){
                throw new IllegalArgumentException("One or more Tour Package Info IDs are invalid");
            }
            tourPackages.setTourPackageType(tourPackageInfo);
        }

        tourPackagesRepository.save(tourPackages);

    }


    @Override
    public void updateTourPackage(Long tourPackageId, TourPackageUpdateDTO tourPackageUpdateDTO) {

        TourPackages tourPackages = tourPackagesRepository.findById(tourPackageId)
                .orElseThrow(() -> new IllegalArgumentException("Tour Package Not Found"));
        BeanUtils.copyProperties(tourPackageUpdateDTO, tourPackages);

        if(tourPackageUpdateDTO.getTourPackageInfoList() != null && !tourPackageUpdateDTO.getTourPackageInfoList().isEmpty()) {
//            List<TourPackageInfo> tourInfo = tourPackageUpdateDTO
//                    .getTourPackageInfoList()
//                    .stream()
//                    .map(
//                            info
//                                    -> {
//                                TourPackageInfo updatedInfo = tourPackageMapper.toEntity(info);
//                                updatedInfo.setTourPackages(tourPackages);
//                                return updatedInfo;
//
//                            })
//                    .collect(Collectors.toList());
 //           tourPackages.setTourPackageType(tourInfo);
        }

        tourPackagesRepository.save(tourPackages);

    }


    public void updateTourPackageInfo(Long id, TourPackageInfoDTO tourPackageInfoDTO) {

        TourPackageInfo tourPackageInfo = tourPackageInfoRepository.findById(id)
                .orElseThrow(()
                                -> new IllegalArgumentException(" Tour Package Not Found"));

        if(tourPackageInfoDTO.getAvailableSeats() >0 )  {
            tourPackageInfo.setAvailableSeats(tourPackageInfoDTO.getAvailableSeats());
        }
        if (tourPackageInfoDTO.getCategory() !=null){
            tourPackageInfo.setCategory(tourPackageInfoDTO.getCategory());
        }
        if(tourPackageInfoDTO.getPrice()>0){
            tourPackageInfo.setPrice(tourPackageInfoDTO.getPrice());
        }
        if(tourPackageInfoDTO.getAllowedPerson() >0){
            tourPackageInfo.setAllowedPerson(tourPackageInfoDTO.getAllowedPerson());
        }

        tourPackageInfoRepository.save(tourPackageInfo);

    }

    @Override
    @Transactional
    public void deleteTourPackage(Long id) {

       TourPackages tourPackages =  tourPackagesRepository.findById(id)
               .orElseThrow(
                       () -> new IllegalArgumentException("Tour Package Not Found"));

       tourPackages.setDeleted(true);
    }

    public List<RegisterTourPackageDTO> searchTourPackage(String tourPackageName) {
        List<TourPackages> tourPackages = tourPackagesRepository.findByName(tourPackageName);
        List<RegisterTourPackageDTO> dtoList = new ArrayList<>();

        for(TourPackages tourPackage: tourPackages){
            dtoList.add(tourPackageMapper.toDto(tourPackage));
        }

        return dtoList;

    }

    public List<RegisterTourPackageDTO> getAllTourPackages() {
        List<TourPackages> tourPackages = tourPackagesRepository.findAll();
        List<RegisterTourPackageDTO> dtoList = new ArrayList<>();

        if(tourPackages.isEmpty()) {
            throw new IllegalArgumentException("No Tour Packages Found");
        }
        for(TourPackages tourPackage : tourPackages){
            dtoList.add(tourPackageMapper.toDto(tourPackage));
        }
        return dtoList;
    }

    @Override
    public TourPackageRepository.TourPackageProjection getTourPackageById(Long id) {
        return tourPackagesRepository.getTourPackageById(id);
    }

    @Override
    public Page<TourPackageRepository.TourPackageProjection> getPaginatedTourPackages(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return tourPackagesRepository.findPaginatedTourPackages(pageable);
    }


}
