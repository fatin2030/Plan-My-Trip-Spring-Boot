package com.fatin_noor.planmytrip.tour_package_category.entity;


import com.fatin_noor.planmytrip.booking.entity.Booking;
import com.fatin_noor.planmytrip.common.audit.Auditable;
import com.fatin_noor.planmytrip.tour_packege.entity.TourPackages;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class TourPackageCategory extends Auditable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "tour_category",nullable = false)
    private String category;
    @Column(name="allowed_person",nullable = false)
    private Integer allowedPerson;
    @Column(name="package_price",nullable = false)
    private float price;
    @Column(name="available_seats",nullable = false)
    private Integer availableSeats;

    @ManyToMany(mappedBy = "tourPackageCategories")
    private List<TourPackages> tourPackagesList;

    @OneToMany (mappedBy = "tourPackageCategory", cascade = CascadeType.ALL)
    private List<Booking> bookingList;

}
