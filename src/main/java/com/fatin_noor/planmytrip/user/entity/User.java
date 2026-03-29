package com.fatin_noor.planmytrip.user.entity;


import com.fatin_noor.planmytrip.booking.entity.Booking;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    private String password;

    private String phone;
    private String profileImageUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="address_id",referencedColumnName = "id")
    private Address address;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id",nullable = false)
    private Role role;


    @OneToMany (mappedBy = "user")
    private List<Booking> bookingList;

    @OneToMany (mappedBy = "user")
    private List<UserCompanyRole> companyUsers;

}
