package com.fatin_noor.planmytrip.mapper;


import com.fatin_noor.planmytrip.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.entity.TourPackages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TourPackageMapper {
    @Mapping(source = "tourPackageInfoList", target = "tourPackageType")

    TourPackages toEntity(RegisterTourPackageDTO registerTourPackageDTO);


    @Mapping(source = "tourPackageType", target = "tourPackageInfoList")
    RegisterTourPackageDTO toDto (TourPackages tourPackages);

    TourPackageInfo toEntity(TourPackageInfoDTO tourPackageInfoDTO);

    TourPackageInfoDTO toDto(TourPackageInfo tourPackageInfoEntity);
    @Mapping(source = "tourPackageType", target = "tourPackageInfoList")
    TourPackageUpdateDTO toUpdate (TourPackages tourPackages);
    List<TourPackageInfoDTO> toDtoList(List<TourPackageInfo> list);
    List<TourPackageInfo> toEntityList(List<TourPackageInfoDTO> list);

}
