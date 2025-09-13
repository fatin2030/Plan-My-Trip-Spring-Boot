package com.fatin_noor.planmytrip.user.repository;

import com.fatin_noor.planmytrip.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {


    Optional<Role> findByRoleName(String roleName);

}
