package com.fatin_noor.planmytrip.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Table(name ="role")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name")
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<User> users;

}
