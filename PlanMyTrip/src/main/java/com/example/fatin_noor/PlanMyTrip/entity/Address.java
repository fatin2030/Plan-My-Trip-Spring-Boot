package com.example.fatin_noor.PlanMyTrip.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "address")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    @Column(name="address_id")
    private Long id;

    @Column(name ="country" , nullable = false)
    private String country;

    @Column(name ="city" , nullable = false)
    private String city;

    @Column(name ="street" , nullable = false)
    private String street;

}
