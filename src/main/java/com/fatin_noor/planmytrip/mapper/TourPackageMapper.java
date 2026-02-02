package com.fatin_noor.planmytrip.mapper;


import com.fatin_noor.planmytrip.tour_package_category.entity.TourPackageCategory;
import com.fatin_noor.planmytrip.tour_packege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tour_package_category.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_packege.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.tour_packege.entity.TourPackages;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TourPackageMapper {
    TourPackages toEntity(RegisterTourPackageDTO registerTourPackageDTO);


    RegisterTourPackageDTO toDto (TourPackages tourPackages);

    TourPackageCategory toEntity(TourPackageInfoDTO tourPackageInfoDTO);

    TourPackageInfoDTO toDto(TourPackageCategory tourPackageCategoryEntity);
    TourPackageUpdateDTO toUpdate (TourPackages tourPackages);
    List<TourPackageInfoDTO> toDtoList(List<TourPackageCategory> list);
    List<TourPackageCategory> toEntityList(List<TourPackageInfoDTO> list);

}
