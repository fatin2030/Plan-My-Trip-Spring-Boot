package com.fatin_noor.planmytrip.user.repository;

import com.fatin_noor.planmytrip.user.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
