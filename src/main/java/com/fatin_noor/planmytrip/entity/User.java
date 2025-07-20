package com.fatin_noor.planmytrip.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="email",nullable = false,unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id",referencedColumnName = "address_id")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id",referencedColumnName = "role_id")
    private Role role;


    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)

    private List<Booking> bookingList;


}
