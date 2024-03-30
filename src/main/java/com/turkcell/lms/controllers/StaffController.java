package com.turkcell.lms.controllers;

import com.turkcell.lms.entities.Staff;
import com.turkcell.lms.services.abstracts.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff/")
@RequiredArgsConstructor
public class StaffController {
    @Autowired
    private final StaffService staffService;

    @GetMapping()
    public List<Staff> getAll(){
        return staffService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Staff> getStaffById(@PathVariable int id){
        return staffService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteStaffById(@PathVariable int id){
        staffService.deleteStaffById(id);
    }

    @PostMapping
    public Staff addStaff(@RequestBody Staff staff){
        return staffService.addStaff(staff);
    }

    @PutMapping
    public Staff updateStaff(@RequestBody Staff staff){
        return staffService.updateStaff(staff);
    }
}