package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> getAll();

    Staff addStaff(Staff staff);

    void deleteStaffById(int id);

    Optional<Staff> getById(int id);

    Staff updateStaff(Staff staff);
}