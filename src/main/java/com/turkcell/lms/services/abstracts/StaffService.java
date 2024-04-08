package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.services.dtos.requests.staff.AddStaffRequest;
import com.turkcell.lms.services.dtos.requests.staff.UpdateStaffRequest;
import com.turkcell.lms.services.dtos.responses.staff.AddStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.GetByIdStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.ListStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.UpdateStaffResponse;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<ListStaffResponse> getAll();

    AddStaffResponse addStaff(AddStaffRequest request);

    void deleteStaffById(int id);

    Optional<GetByIdStaffResponse> getById(int id);

    UpdateStaffResponse updateStaff(int id, UpdateStaffRequest request);
}