package com.example.fatin_noor.PlanMyTrip.repository;

import com.example.fatin_noor.PlanMyTrip.entity.TourPackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TourPackagesRepository  extends JpaRepository<TourPackages,Long> {

    Optional<TourPackages> findById(Long id);

  //  Optional<TourPackages> updateTourPackage(TourPackages tourPackages);
}
