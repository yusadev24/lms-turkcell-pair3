package com.turkcell.lms.repositories;

import com.turkcell.lms.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
