package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Member;
import com.turkcell.lms.entities.Staff;
import com.turkcell.lms.repositories.StaffRepository;
import com.turkcell.lms.services.abstracts.StaffService;
import com.turkcell.lms.services.dtos.requests.staff.AddStaffRequest;
import com.turkcell.lms.services.dtos.requests.staff.UpdateStaffRequest;
import com.turkcell.lms.services.dtos.responses.member.AddMemberResponse;
import com.turkcell.lms.services.dtos.responses.member.UpdateMemberResponse;
import com.turkcell.lms.services.dtos.responses.staff.AddStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.GetByIdStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.ListStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.UpdateStaffResponse;
import com.turkcell.lms.services.mappers.MemberMapper;
import com.turkcell.lms.services.mappers.StaffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    @Autowired
    private final StaffRepository staffRepository;

    @Override
    public List<ListStaffResponse> getAll() {
        List<Staff> staff = staffRepository.findAll();

        return StaffMapper.INSTANCE.staffToListStaffResponses(staff);
    }

    @Override
    public AddStaffResponse addStaff(AddStaffRequest request) {
        if(request.getName().length() < 3)
            throw new RuntimeException("Staff should be at least 3 letters long.");
        // Auto Mapping utilizing MapStruck
        Staff staff = StaffMapper.INSTANCE.staffFromRequest(request);
        Staff savedStaff = staffRepository.save(staff);
        AddStaffResponse response = new AddStaffResponse(savedStaff.getId(),
                savedStaff.getName(),
                savedStaff.getSurname(),
                savedStaff.getRole(),
                savedStaff.getPassword(),
                savedStaff.getEmail(),
                savedStaff.getStaffNumber());

        return response;
    }

    @Override
    public void deleteStaffById(int id) {
        if (!staffRepository.existsById(id)) {
            throw new IllegalArgumentException("Staff with ID " + id + " does not exist");
        }
        staffRepository.deleteById(id);
    }

    @Override
    public Optional<GetByIdStaffResponse> getById(int id) {
        Optional<Staff> staffOptional = staffRepository.findById(id);

        return staffOptional.map(StaffMapper.INSTANCE::mapToGetByIdStaffResponse);
    }

    @Override
    public UpdateStaffResponse updateStaff(int id, UpdateStaffRequest request) {
        Optional<Staff> staffOptional = staffRepository.findById(id);
        UpdateStaffResponse response = new UpdateStaffResponse();

        staffOptional.ifPresent(staff -> {
            Staff updatedStaff = StaffMapper.INSTANCE.updateStaffFromRequest(id, staff);
            Staff savedStaff = staffRepository.save(updatedStaff);

            response.setId(savedStaff.getId());
            response.setName(savedStaff.getName());
            response.setSurname(savedStaff.getSurname());
            response.setPassword(savedStaff.getPassword());
            response.setEmail(savedStaff.getEmail());
            response.setRole(savedStaff.getRole());
            response.setStaffNumber(savedStaff.getStaffNumber());
        });

        return response;
    }
}