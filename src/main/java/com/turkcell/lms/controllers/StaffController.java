package com.turkcell.lms.controllers;

import com.turkcell.lms.services.abstracts.StaffService;
import com.turkcell.lms.services.dtos.requests.staff.AddStaffRequest;
import com.turkcell.lms.services.dtos.requests.staff.UpdateStaffRequest;
import com.turkcell.lms.services.dtos.responses.staff.AddStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.GetByIdStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.ListStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.UpdateStaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff/")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping()
    public List<ListStaffResponse> getAll(){
        return staffService.getAll();
    }

    @GetMapping("{id}")
    public Optional<GetByIdStaffResponse> getStaffById(@PathVariable int id){
        return staffService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteStaffById(@PathVariable int id){
        staffService.deleteStaffById(id);
    }

    @PostMapping
    public ResponseEntity<AddStaffResponse> addStaff(@RequestBody AddStaffRequest request)
    {
        AddStaffResponse response = staffService.addStaff(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("{id}")
    public UpdateStaffResponse updateStaff(@PathVariable int id, @RequestBody UpdateStaffRequest request){
        return staffService.updateStaff(id, request);
    }
}