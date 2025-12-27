package com.fatin_noor.planmytrip.tourPackageInfo.entity;


import com.fatin_noor.planmytrip.booking.entity.Booking;
import com.fatin_noor.planmytrip.common.audit.Auditable;
import com.fatin_noor.planmytrip.tourpackege.entity.TourPackages;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class TourPackageInfo extends Auditable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="tour_category_id")
    private Long tourCategoryId;

    @Column(name = "tour_category",nullable = false)
    private String category;
    @Column(name="allowed_person",nullable = false)
    private Integer allowedPerson;
    @Column(name="package_price",nullable = false)
    private float price;
    @Column(name="available_seats",nullable = false)
    private Integer availableSeats;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tour_package_id")
    private TourPackages tourPackages;

    @OneToMany (mappedBy = "tourPackageInfo", cascade = CascadeType.ALL)
    private List<Booking> bookingList;

}
