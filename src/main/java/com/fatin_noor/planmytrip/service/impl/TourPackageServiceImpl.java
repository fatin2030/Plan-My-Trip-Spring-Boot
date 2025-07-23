package com.fatin_noor.planmytrip.service.impl;

import com.fatin_noor.planmytrip.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.entity.TourPackages;
import com.fatin_noor.planmytrip.mapper.TourPackageMapper;
import com.fatin_noor.planmytrip.repository.TourPackageInfoRepository;
import com.fatin_noor.planmytrip.repository.TourPackagesRepository;
import com.fatin_noor.planmytrip.service.TourPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TourPackageServiceImpl implements TourPackageService {
    private final TourPackagesRepository tourPackagesRepository;
    private final TourPackageInfoRepository tourPackageInfoRepository;
    private final TourPackageMapper tourPackageMapper;


    public void registerTourPackage(RegisterTourPackageDTO registerTourPackageDTO){

        TourPackages tourPackages = tourPackageMapper.toEntity(registerTourPackageDTO);

        tourPackages.getTourPackageType().forEach(info -> info.setTourPackages(tourPackages));

        tourPackagesRepository.save(tourPackages);

    }

//    public AddTourPackageInfoDTO addTourPackageInfo(Long packageId, AddTourPackageInfoDTO addTourPackageInfoDTO){
//
//        TourPackages tourPackage = tourPackagesRepository.findById(packageId).orElseThrow(() -> new IllegalArgumentException("Tour Package Not FOund"));
//        TourPackageInfo t1 = tourPackageMapper.toEntity(addTourPackageInfoDTO);
//        tourPackage.getTourPackageType().forEach(info -> info.setTourPackages(tourPackage));
//
//        TourPackageInfo saved = tourPackageInfoRepository.save(t1);
//
//        return  tourPackageMapper.toDto(saved);
//
//    }



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


    public void updateTourPackage(Long tourPackageId, TourPackageUpdateDTO tourPackageUpdateDTO) {

        TourPackages tourPackages = tourPackagesRepository.findById(tourPackageId)
                .orElseThrow(() -> new IllegalArgumentException("Tour Package Not Found"));

        if (tourPackageUpdateDTO.getTourPackageName() != null && !tourPackageUpdateDTO.getTourPackageName().isEmpty()) {
            tourPackages.setTourPackageName(tourPackageUpdateDTO.getTourPackageName());
        }

        if (tourPackageUpdateDTO.getDescription() != null && !tourPackageUpdateDTO.getDescription().isEmpty()) {
            tourPackages.setDescription(tourPackageUpdateDTO.getDescription());
        }

        if (tourPackageUpdateDTO.getStartDate() != null) {
            tourPackages.setStartDate(tourPackageUpdateDTO.getStartDate());
        }

        if (tourPackageUpdateDTO.getEndDate() != null) {
            tourPackages.setEndDate(tourPackageUpdateDTO.getEndDate());
        }
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

    public void deleteTourPackage(Long id) {

       TourPackages tourPackages =  tourPackagesRepository.findById(id)
               .orElseThrow(
                       () -> new IllegalArgumentException("Tour Package Not Found"));

       tourPackagesRepository.delete(tourPackages);

    }

    public List<RegisterTourPackageDTO> searchTourPackage(String tourPackageName) {
//        List<TourPackages> entities = tourPackagesRepository.findByName(tourPackageName);
//        return entities.stream()
//                .map(tourPackageMapper::toDto) // or toTourPackageDto if you prefer
//                .collect(Collectors.toList());
//        return tourPackages
//                .stream()
//                .map(
//                        info ->
//                        {
//                            return tourPackageMapper.toDto(info);
//                        }
//                ).toList();
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


}
