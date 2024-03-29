package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.services.responses.GetAllMembersResponse;

import java.util.List;

public interface MemberService {
    List<GetAllMembersResponse> getAll();
}
