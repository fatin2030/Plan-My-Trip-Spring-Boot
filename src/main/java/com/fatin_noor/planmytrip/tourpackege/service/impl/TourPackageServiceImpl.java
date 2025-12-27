package com.fatin_noor.planmytrip.tourpackege.service.impl;

import com.fatin_noor.planmytrip.tourPackageInfo.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tourPackageInfo.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.tourPackageInfo.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.tourpackege.entity.TourPackages;
import com.fatin_noor.planmytrip.mapper.TourPackageMapper;
import com.fatin_noor.planmytrip.tourPackageInfo.repository.TourPackageInfoRepository;
import com.fatin_noor.planmytrip.tourpackege.repository.TourPackageRepository;
import com.fatin_noor.planmytrip.tourpackege.service.TourPackageService;
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

        tourPackagesRepository.save(tourPackageMapper.toEntity(registerTourPackageDTO));

    }


    @Override
    public void updateTourPackage(Long tourPackageId, TourPackageUpdateDTO tourPackageUpdateDTO) {

        TourPackages tourPackages = tourPackagesRepository.findById(tourPackageId)
                .orElseThrow(() -> new IllegalArgumentException("Tour Package Not Found"));
        BeanUtils.copyProperties(tourPackageUpdateDTO, tourPackages);

        if(tourPackageUpdateDTO.getTourPackageInfoList() != null && !tourPackageUpdateDTO.getTourPackageInfoList().isEmpty()) {
            List<TourPackageInfo> tourInfo = tourPackageUpdateDTO
                    .getTourPackageInfoList()
                    .stream()
                    .map(
                            info
                                    -> {
                                TourPackageInfo updatedInfo = tourPackageMapper.toEntity(info);
                                updatedInfo.setTourPackages(tourPackages);
                                return updatedInfo;

                            })
                    .collect(Collectors.toList());
            tourPackages.setTourPackageType(tourInfo);
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
