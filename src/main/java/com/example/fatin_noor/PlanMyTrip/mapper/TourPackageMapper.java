package com.example.fatin_noor.PlanMyTrip.mapper;


import com.example.fatin_noor.PlanMyTrip.dto.RegisterTourPackageDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageUpdateDTO;
import com.example.fatin_noor.PlanMyTrip.entity.TourPackageInfo;
import com.example.fatin_noor.PlanMyTrip.entity.TourPackages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TourPackageMapper {
    @Mapping(source = "tourPackageInfoList", target = "tourPackageType")

    TourPackages toEntity(RegisterTourPackageDTO registerTourPackageDTO);

    @Mapping(source = "tourPackageType", target = "tourPackageInfoList")

    RegisterTourPackageDTO toDto (TourPackages tourPackages);

    TourPackageInfo toEntity(TourPackageInfoDTO tourPackageInfoDTO);

    TourPackageInfoDTO toDto(TourPackageInfo tourPackageInfoEntity);

    TourPackageUpdateDTO toUpdate (TourPackages tourPackages);


}
