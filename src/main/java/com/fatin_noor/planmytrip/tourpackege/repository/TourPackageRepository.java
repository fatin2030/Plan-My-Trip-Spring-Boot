package com.fatin_noor.planmytrip.tourpackege.repository;

import com.fatin_noor.planmytrip.tourpackege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tourpackege.entity.TourPackages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface TourPackageRepository extends JpaRepository<TourPackages, Long> {

    @Query("SELECT DISTINCT t FROM TourPackages t LEFT JOIN FETCH t.tourPackageType t2 WHERE t.tourPackageName LIKE %:name%")
    List<TourPackages> findByName(@Param("name") String name);

    Optional<TourPackages> findById(Long id);

    @Query(value = """
            SELECT
                t.id AS id,
                t.created_at AS createdAt,
                t.tour_package_name AS tourPackageName,
                t.description AS description,
                t.start_date AS startDate,
                t.end_date AS endDate
            FROM tour_packages t
            """, nativeQuery = true)
    List<?> findAllPackageSummaries();

    @Query(value = """
            SELECT
              t.id AS id,
              t.tour_package_name AS tourPackageName,
              t.description AS description,
              t.start_date AS startDate,
              t.end_date AS endDate,
              t.created_at AS createdAt,
              t.updated_at AS updatedAt
            FROM tour_packages t
            WHERE t.id = :id
            """, nativeQuery = true)
    TourPackageProjection getTourPackageById(@Param("id") Long id);

    String TOUR_PACKAGE_PAGINATED_LIST = """
            SELECT
              t.id AS id,
              t.tour_package_name AS tourPackageName,
              t.description AS description,
              t.start_date AS startDate,
              t.end_date AS endDate,
              t.created_at AS createdAt,
              t.updated_at AS updatedAt
            FROM tour_packages t
            ORDER BY t.created_at DESC
            """;

    String COUNT_TOUR_PACKAGES = """
            SELECT
              COUNT(*)
            FROM tour_packages t
            """;
    @Query(value = TOUR_PACKAGE_PAGINATED_LIST, countQuery = COUNT_TOUR_PACKAGES, nativeQuery = true)
    Page<TourPackageProjection> findPaginatedTourPackages(Pageable pageable);

    interface TourPackageProjection {
        Long getId();

        String getTourPackageName();

        String getDescription();

        LocalDate getStartDate();

        LocalDate getEndDate();

        LocalDate getCreatedAt();

        LocalDate getUpdatedAt();
    }

}
