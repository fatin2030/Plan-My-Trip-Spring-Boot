package com.fatin_noor.planmytrip.tourPackageInfo.repository;


import com.fatin_noor.planmytrip.tourPackageInfo.entity.TourPackageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourPackageInfoRepository extends JpaRepository<TourPackageInfo,Long> {
    Optional<TourPackageInfo> findById(Long aLong);
}
