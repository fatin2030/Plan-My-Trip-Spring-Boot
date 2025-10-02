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
    @Column(name = "user_id")
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    private String password;

    private String phone;
    private String profileImageUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id",referencedColumnName = "address_id")
    private Address address;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id",nullable = false)
    private Role role;


    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)

    private List<Booking> bookingList;

}
