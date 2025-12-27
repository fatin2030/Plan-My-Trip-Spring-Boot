package com.fatin_noor.planmytrip.tourpackege.entity;
import com.fatin_noor.planmytrip.common.audit.Auditable;
import com.fatin_noor.planmytrip.tourPackageInfo.entity.TourPackageInfo;
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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tourPackages")
    private List<TourPackageInfo> tourPackageType;



}
