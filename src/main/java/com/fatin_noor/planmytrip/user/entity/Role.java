package com.fatin_noor.planmytrip.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name ="role")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
