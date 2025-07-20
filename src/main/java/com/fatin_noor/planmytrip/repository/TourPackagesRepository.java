package com.fatin_noor.planmytrip.repository;
import com.fatin_noor.planmytrip.entity.TourPackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface TourPackagesRepository  extends JpaRepository<TourPackages,Long> {

    @Query("SELECT DISTINCT t FROM TourPackages t LEFT JOIN FETCH t.tourPackageType t2 WHERE t.tourPackageName LIKE %:name%")
    List<TourPackages> findByName(@Param("name") String name);

    Optional<TourPackages> findById(Long id);

}
