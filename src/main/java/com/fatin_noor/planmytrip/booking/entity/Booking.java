package com.fatin_noor.planmytrip.booking.entity;

import com.fatin_noor.planmytrip.tourpackege.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.user.entity.User;
import com.fatin_noor.planmytrip.enums.Status;
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "tour_info_id")
    private TourPackageInfo tourPackageInfo;



}
