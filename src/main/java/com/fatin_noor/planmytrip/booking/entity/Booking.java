package com.fatin_noor.planmytrip.booking.entity;

import com.fatin_noor.planmytrip.package_price.entity.PackageCategoryOffering;
import com.fatin_noor.planmytrip.user.entity.User;
import com.fatin_noor.planmytrip.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table
@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="booking_date")
    private LocalDate bookingDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    private PackageCategoryOffering packageCategoryOffering;



}
