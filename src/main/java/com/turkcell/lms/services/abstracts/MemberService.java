package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.services.dtos.requests.member.AddMemberRequest;
import com.turkcell.lms.services.dtos.requests.member.UpdateMemberRequest;
import com.turkcell.lms.services.dtos.responses.member.AddMemberResponse;
import com.turkcell.lms.services.dtos.responses.member.GetByIdMemberResponse;
import com.turkcell.lms.services.dtos.responses.member.UpdateMemberResponse;
import com.turkcell.lms.services.dtos.responses.member.ListMemberResponse;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<ListMemberResponse> getAll();

    AddMemberResponse addMember(AddMemberRequest request);

    void deleteMemberById(int id);

    Optional<GetByIdMemberResponse> getById(int id);

    UpdateMemberResponse updateMember(int id, UpdateMemberRequest request);
}
