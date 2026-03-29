package com.fatin_noor.planmytrip.tour_packege.entity;
import com.fatin_noor.planmytrip.common.audit.Auditable;
import com.fatin_noor.planmytrip.company.entity.Company;
import com.fatin_noor.planmytrip.package_price.entity.PackageCategoryOffering;
import jakarta.persistence.*;
import lombok.Data;

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
    private List<PackageCategoryOffering> packageCategoryOfferings;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;


}
