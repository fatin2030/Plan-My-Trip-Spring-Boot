package com.example.fatin_noor.PlanMyTrip.mapper;

import com.example.fatin_noor.PlanMyTrip.dto.RegisterTourPackageDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageUpdateDTO;
import com.example.fatin_noor.PlanMyTrip.entity.TourPackageInfo;
import com.example.fatin_noor.PlanMyTrip.entity.TourPackages;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-14T15:17:14+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Ubuntu)"
)
@Component
public class TourPackageMapperImpl implements TourPackageMapper {

    @Override
    public TourPackages toEntity(RegisterTourPackageDTO registerTourPackageDTO) {
        if ( registerTourPackageDTO == null ) {
            return null;
        }

        TourPackages tourPackages = new TourPackages();

        tourPackages.setTourPackageType( tourPackageInfoDTOListToTourPackageInfoList( registerTourPackageDTO.getTourPackageInfoList() ) );
        tourPackages.setTourPackageName( registerTourPackageDTO.getTourPackageName() );
        tourPackages.setDescription( registerTourPackageDTO.getDescription() );
        tourPackages.setStartDate( registerTourPackageDTO.getStartDate() );
        tourPackages.setEndDate( registerTourPackageDTO.getEndDate() );

        return tourPackages;
    }

    @Override
    public RegisterTourPackageDTO toDto(TourPackages tourPackages) {
        if ( tourPackages == null ) {
            return null;
        }

        RegisterTourPackageDTO registerTourPackageDTO = new RegisterTourPackageDTO();

        registerTourPackageDTO.setTourPackageInfoList( tourPackageInfoListToTourPackageInfoDTOList( tourPackages.getTourPackageType() ) );
        registerTourPackageDTO.setTourPackageName( tourPackages.getTourPackageName() );
        registerTourPackageDTO.setDescription( tourPackages.getDescription() );
        registerTourPackageDTO.setStartDate( tourPackages.getStartDate() );
        registerTourPackageDTO.setEndDate( tourPackages.getEndDate() );

        return registerTourPackageDTO;
    }

    @Override
    public TourPackageInfo toEntity(TourPackageInfoDTO tourPackageInfoDTO) {
        if ( tourPackageInfoDTO == null ) {
            return null;
        }

        TourPackageInfo tourPackageInfo = new TourPackageInfo();

        tourPackageInfo.setCategory( tourPackageInfoDTO.getCategory() );
        tourPackageInfo.setAllowedPerson( tourPackageInfoDTO.getAllowedPerson() );
        tourPackageInfo.setPrice( tourPackageInfoDTO.getPrice() );
        tourPackageInfo.setAvailableSeats( tourPackageInfoDTO.getAvailableSeats() );

        return tourPackageInfo;
    }

    @Override
    public TourPackageInfoDTO toDto(TourPackageInfo tourPackageInfoEntity) {
        if ( tourPackageInfoEntity == null ) {
            return null;
        }

        TourPackageInfoDTO tourPackageInfoDTO = new TourPackageInfoDTO();

        tourPackageInfoDTO.setCategory( tourPackageInfoEntity.getCategory() );
        tourPackageInfoDTO.setAllowedPerson( tourPackageInfoEntity.getAllowedPerson() );
        tourPackageInfoDTO.setPrice( tourPackageInfoEntity.getPrice() );
        tourPackageInfoDTO.setAvailableSeats( tourPackageInfoEntity.getAvailableSeats() );

        return tourPackageInfoDTO;
    }

    @Override
    public TourPackageUpdateDTO toUpdate(TourPackages tourPackages) {
        if ( tourPackages == null ) {
            return null;
        }

        TourPackageUpdateDTO tourPackageUpdateDTO = new TourPackageUpdateDTO();

        tourPackageUpdateDTO.setTourPackageName( tourPackages.getTourPackageName() );
        tourPackageUpdateDTO.setDescription( tourPackages.getDescription() );
        tourPackageUpdateDTO.setStartDate( tourPackages.getStartDate() );
        tourPackageUpdateDTO.setEndDate( tourPackages.getEndDate() );

        return tourPackageUpdateDTO;
    }

    protected List<TourPackageInfo> tourPackageInfoDTOListToTourPackageInfoList(List<TourPackageInfoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TourPackageInfo> list1 = new ArrayList<TourPackageInfo>( list.size() );
        for ( TourPackageInfoDTO tourPackageInfoDTO : list ) {
            list1.add( toEntity( tourPackageInfoDTO ) );
        }

        return list1;
    }

    protected List<TourPackageInfoDTO> tourPackageInfoListToTourPackageInfoDTOList(List<TourPackageInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<TourPackageInfoDTO> list1 = new ArrayList<TourPackageInfoDTO>( list.size() );
        for ( TourPackageInfo tourPackageInfo : list ) {
            list1.add( toDto( tourPackageInfo ) );
        }

        return list1;
    }
}
