package com.fatin_noor.planmytrip.tour_packege.entity;
import com.fatin_noor.planmytrip.common.audit.Auditable;
import com.fatin_noor.planmytrip.package_price.entity.PackageCategoryOffering;
import com.fatin_noor.planmytrip.tour_package_category.entity.TourPackageCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Table
@Entity
public class TourPackages extends Auditable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name="tour_package_name",nullable = false)
    private String tourPackageName;
    @Column(name="description",columnDefinition = "TEXT",nullable = false)
    private String description;

    @OneToMany(mappedBy = "tourPackages",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<PackageCategoryOffering> packageCategoryOffering;


}
