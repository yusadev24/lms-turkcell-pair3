package com.turkcell.lms.services.mappers;

import com.turkcell.lms.entities.Staff;
import com.turkcell.lms.services.dtos.requests.staff.AddStaffRequest;
import com.turkcell.lms.services.dtos.responses.staff.GetByIdStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.ListStaffResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StaffMapper {


    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    Staff staffFromRequest(AddStaffRequest request);

    GetByIdStaffResponse mapToGetByIdStaffResponse(Staff staff);

    ListStaffResponse staffToListStaffResponse(Staff staff);

    List<ListStaffResponse> staffToListStaffResponses(List<Staff> staff);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    Staff updateStaffFromRequest(int id, Staff existingStaff);
}
