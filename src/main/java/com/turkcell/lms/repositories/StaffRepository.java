package com.turkcell.lms.repositories;

import com.turkcell.lms.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff,Integer> {

    Optional<Staff> findByStaffNumber(int staffNumber);
    Optional<Staff> findByEmail(String email);
}
