package com.example.fatin_noor.PlanMyTrip.repository;


import com.example.fatin_noor.PlanMyTrip.entity.TourPackageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourPackageInfoRepository extends JpaRepository<TourPackageInfo,Long> {
    Optional<TourPackageInfo> findById(Long aLong);
}
