package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Member;
import com.turkcell.lms.services.responses.GetAllMembersResponse;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<GetAllMembersResponse> getAll();

   Member saveMember(Member member);

    Optional<Member> getById(int id);
}
