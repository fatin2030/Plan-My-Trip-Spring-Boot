package com.fatin_noor.planmytrip.user.repository;

import com.fatin_noor.planmytrip.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    Optional<User> findById(Long aLong);
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u ")
    List<User> users();
}
