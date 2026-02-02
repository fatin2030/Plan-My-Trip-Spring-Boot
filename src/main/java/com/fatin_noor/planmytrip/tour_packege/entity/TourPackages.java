package com.fatin_noor.planmytrip.tour_packege.entity;
import com.fatin_noor.planmytrip.common.audit.Auditable;
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
    @Column(name="start_date",nullable = false)
    private LocalDate startDate;
    @Column(name="end_date",nullable = false)
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "tour_package_tour_category",
            joinColumns = @JoinColumn(name = "tour_package_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_category_id")
    )
    private List<TourPackageCategory> tourPackageCategories;


}
