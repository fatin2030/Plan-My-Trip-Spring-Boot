package com.fatin_noor.planmytrip.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class TourPackageInfo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="tour_category_id")
    private Long tourCategoryId;

    @Column(name = "tour_category",nullable = false)
    private String category;
    @Column(name="allowed_person",nullable = false)
    private int allowedPerson;
    @Column(name="package_price",nullable = false)
    private float price;
    @Column(name="available_seats",nullable = false)
    private int availableSeats;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tour_package_id")
    private TourPackages tourPackages;

    @OneToMany (mappedBy = "tourPackageInfo", cascade = CascadeType.ALL)

    private List<Booking> bookingList;

}
