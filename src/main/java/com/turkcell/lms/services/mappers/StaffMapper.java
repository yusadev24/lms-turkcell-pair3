package com.turkcell.lms.services.mappers;

import com.turkcell.lms.entities.Staff;
import com.turkcell.lms.services.dtos.requests.staff.AddStaffRequest;
import com.turkcell.lms.services.dtos.requests.staff.UpdateStaffRequest;
import com.turkcell.lms.services.dtos.responses.staff.GetByIdStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.ListStaffResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StaffMapper {


    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    Staff staffFromRequest(AddStaffRequest request);

    GetByIdStaffResponse mapToGetByIdStaffResponse(Staff staff);

    ListStaffResponse staffToListStaffResponse(Staff staff);

    List<ListStaffResponse> staffToListStaffResponses(List<Staff> staff);


    Staff updateStaffFromRequest(UpdateStaffRequest request, @MappingTarget Staff staff);
}
