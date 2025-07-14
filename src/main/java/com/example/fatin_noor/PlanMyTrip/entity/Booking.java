package com.example.fatin_noor.PlanMyTrip.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table
@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name="booking_date")
    private LocalDate bookingDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "tour_info_id")
    private TourPackageInfo tourPackageInfo;



}
