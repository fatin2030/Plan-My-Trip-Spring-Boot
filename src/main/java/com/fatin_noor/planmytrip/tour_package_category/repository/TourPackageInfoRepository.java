package com.fatin_noor.planmytrip.tour_package_category.repository;


import com.fatin_noor.planmytrip.tour_package_category.entity.TourPackageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourPackageInfoRepository extends JpaRepository<TourPackageInfo,Long> {
    Optional<TourPackageInfo> findById(Long aLong);

    List<TourPackageInfo> findByIdIn(List<Long> ids);
}
