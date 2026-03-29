package com.fatin_noor.planmytrip.tour_package_category.entity;


import com.fatin_noor.planmytrip.common.audit.Auditable;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table
public class TourPackageCategory extends Auditable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "tour_category",nullable = false)
    private String category;

}
