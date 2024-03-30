package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Staff;
import com.turkcell.lms.repositories.StaffRepository;
import com.turkcell.lms.services.abstracts.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteStaffById(int id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Optional<Staff> getById(int id) {
        return Optional.of(staffRepository.getById(id));
    }

    @Override
    public Staff updateStaff(Staff staff) {
        int id = staff.getId();
        if (!staffRepository.existsById(id)) {
            throw new IllegalArgumentException("Staff with ID " + id + " does not exist");
        }
        return staffRepository.save(staff);
    }
}