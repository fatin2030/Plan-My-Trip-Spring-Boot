package com.fatin_noor.planmytrip.tour_package_category.repository;


import com.fatin_noor.planmytrip.tour_package_category.entity.TourPackageCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourPackageInfoRepository extends JpaRepository<TourPackageCategory,Long> {
    Optional<TourPackageCategory> findById(Long aLong);

    List<TourPackageCategory> findByIdIn(List<Long> ids);
}
