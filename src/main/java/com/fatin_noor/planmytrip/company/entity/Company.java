package com.fatin_noor.planmytrip.company.entity;

import com.fatin_noor.planmytrip.common.audit.Auditable;
import com.fatin_noor.planmytrip.enums.Status;
import com.fatin_noor.planmytrip.tour_packege.entity.TourPackages;
import com.fatin_noor.planmytrip.user.entity.UserCompanyRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Company extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String companyName;

    private String tradeLicenseNo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TourPackages> tourPackages;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCompanyRole> companyUsers;
}
