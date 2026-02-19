package com.fatin_noor.planmytrip.package_price.entity;

import com.fatin_noor.planmytrip.tour_package_category.entity.TourPackageCategory;
import com.fatin_noor.planmytrip.tour_packege.entity.TourPackages;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class PackageCategoryOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private TourPackages tourPackages;

    @ManyToOne(fetch = FetchType.LAZY)
    private TourPackageCategory tourPackageCategory;

    private BigDecimal price;

    private Long availableSeats;

    private LocalDate validFrom;

    private LocalDate validTo;

}
