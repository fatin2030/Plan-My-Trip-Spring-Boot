package com.example.fatin_noor.PlanMyTrip.serviceImpl;

import com.example.fatin_noor.PlanMyTrip.dto.AddTourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.dto.RegisterTourPackageDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.entity.TourPackageInfo;
import com.example.fatin_noor.PlanMyTrip.entity.TourPackages;
import com.example.fatin_noor.PlanMyTrip.mapper.TourPackageMapper;
import com.example.fatin_noor.PlanMyTrip.repository.TourPackageInfoRepository;
import com.example.fatin_noor.PlanMyTrip.repository.TourPackagesRepository;
import com.example.fatin_noor.PlanMyTrip.service.TourPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourPackageServiceImpl implements TourPackageService {
    private final TourPackagesRepository tourPackagesRepository;
    private final TourPackageInfoRepository tourPackageInfoRepository;
    private final TourPackageMapper tourPackageMapper;

//    @Autowired
//    public TourPackageServiceImpl(TourPackagesRepository tourPackagesRepository, TourPackageMapper tourPackageMapper, TourPackageInfoRepository tourPackageInfoRepository){
//        this.tourPackagesRepository = tourPackagesRepository;
//        this.tourPackageMapper =  tourPackageMapper;
//        this.tourPackageInfoRepository = tourPackageInfoRepository;
//    }

//    public RegisterTourPackageDTO registerTourPackage(RegisterTourPackageDTO addTourPackageDto) {
//
//        // Create TourPackages entity
//        TourPackages tourPackages = new TourPackages();
//        tourPackages.setTourPackageName(addTourPackageDto.getTourPackageName());
//        tourPackages.setDescription(addTourPackageDto.getDescription());
//        tourPackages.setStartDate(addTourPackageDto.getStartDate());
//        tourPackages.setEndDate(addTourPackageDto.getEndDate());
//
//        // Map DTOs to TourPackageInfo entities
//        List<TourPackageInfo> infoList = addTourPackageDto.getTourPackageInfoList().stream().map(infoDto -> {
//            TourPackageInfo tourPackageInfo = new TourPackageInfo();
//            tourPackageInfo.setCategory(infoDto.getCategory());
//            tourPackageInfo.setPrice(infoDto.getPrice());
//            tourPackageInfo.setAvailableSeats(infoDto.getAvailableSeats());
//            tourPackageInfo.setAllowedPerson(infoDto.getAllowedPerson()); // if field exists
//            tourPackageInfo.setTourPackages(tourPackages); // Set the owning side
//            return tourPackageInfo;
//        }).toList();
//
//        tourPackages.setTourPackageType(infoList);
//
//        // Save parent and cascade children
//        TourPackages tourPackage = tourPackagesRepository.save(tourPackages);
//
//        // Map back to DTO if needed
//        RegisterTourPackageDTO responseDTO = new RegisterTourPackageDTO();
//        BeanUtils.copyProperties(tourPackage,responseDTO);
//        /*responseDTO.setTourPackageName(saved.getTourPackageName());
//        responseDTO.setDescription(saved.getDescription());
//        responseDTO.setStartDate(saved.getStartDate());
//        responseDTO.setEndDate(saved.getEndDate());*/
//
//        List<TourPackageInfoDTO> responseInfos = tourPackage.getTourPackageType().stream().map(info -> {
//            TourPackageInfoDTO dto = new TourPackageInfoDTO();
//            BeanUtils.copyProperties(info,dto);
//            /*dto.setCategory(info.getCategory());
//            dto.setPrice(info.getPrice());
//            dto.setAvailableSeats(info.getAvailableSeats());
//            dto.setAllowedPerson(info.getAllowedPerson());*/
//            return dto;
//        }).toList();
//
//        responseDTO.setTourPackageInfoList(responseInfos);
//
//        return responseDTO;
//    }

    public RegisterTourPackageDTO registerTourPackage(RegisterTourPackageDTO registerTourPackageDTO){

        TourPackages tourPackages = tourPackageMapper.toEntity(registerTourPackageDTO);

        tourPackages.getTourPackageType().forEach(info -> info.setTourPackages(tourPackages));

        TourPackages saved = tourPackagesRepository.save(tourPackages);
        return tourPackageMapper.toDto(saved);
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



    public List<TourPackageInfoDTO> addTourPackageInfo(Long id, AddTourPackageInfoDTO addTourPackageInfoDTO) {
        TourPackages tourPackage = tourPackagesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tour Package Not FOund"));

        List<TourPackageInfo> tourPackageInfos = addTourPackageInfoDTO.getTourPackageInfoList().stream().map(infoDto -> {
            TourPackageInfo tourInfo = tourPackageMapper.toEntity(infoDto);
            tourInfo.setTourPackages(tourPackage);
            return tourInfo;
        }).toList();
       return tourPackageInfoRepository.saveAll(tourPackageInfos)
               .stream()
               .map(info->tourPackageMapper.toDto(info))
               .toList();

    }







}
