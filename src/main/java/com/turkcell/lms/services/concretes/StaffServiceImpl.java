package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Staff;
import com.turkcell.lms.repositories.StaffRepository;
import com.turkcell.lms.services.abstracts.StaffService;
import com.turkcell.lms.services.dtos.requests.staff.AddStaffRequest;
import com.turkcell.lms.services.dtos.requests.staff.UpdateStaffRequest;
import com.turkcell.lms.services.dtos.responses.staff.AddStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.GetByIdStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.ListStaffResponse;
import com.turkcell.lms.services.dtos.responses.staff.UpdateStaffResponse;
import com.turkcell.lms.services.mappers.StaffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    @Override
    public List<ListStaffResponse> getAll() {
        List<Staff> staff = staffRepository.findAll();

        return StaffMapper.INSTANCE.staffToListStaffResponses(staff);
    }

    @Override
    public AddStaffResponse addStaff(AddStaffRequest request) {
        // Auto Mapping utilizing MapStruck
        Staff staff = StaffMapper.INSTANCE.staffFromRequest(request);
        Staff savedStaff = staffRepository.save(staff);
        AddStaffResponse response = new AddStaffResponse(savedStaff.getId(),
                savedStaff.getName(),
                savedStaff.getSurname(),
                savedStaff.getRole(),
                savedStaff.getEmail(),
                savedStaff.getPassword(),
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
            Staff updatedStaff = StaffMapper.INSTANCE.updateStaffFromRequest(request, staff);

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