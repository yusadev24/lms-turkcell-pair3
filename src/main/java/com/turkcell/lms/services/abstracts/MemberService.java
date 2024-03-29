package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Member;
import com.turkcell.lms.services.responses.GetAllMembersResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<GetAllMembersResponse> getAll();

    Member addMember(Member member);

    void deleteMemberById(int id);

    Optional<Member> getById(int id);

    Member updateMember(Member member);
}
