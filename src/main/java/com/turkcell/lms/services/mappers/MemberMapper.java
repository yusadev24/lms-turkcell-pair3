package com.turkcell.lms.services.mappers;

import com.turkcell.lms.entities.Member;
import com.turkcell.lms.services.dtos.requests.member.AddMemberRequest;
import com.turkcell.lms.services.dtos.requests.member.UpdateMemberRequest;
import com.turkcell.lms.services.dtos.responses.member.GetByIdMemberResponse;
import com.turkcell.lms.services.dtos.responses.member.ListMemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member memberFromRequest(AddMemberRequest request);

    GetByIdMemberResponse mapToGetByIdMemberResponse(Member member);

    ListMemberResponse memberToListMemberResponse(Member member);
    List<ListMemberResponse> membersToListMemberResponses(List<Member> members);


    Member updateMemberFromRequest(UpdateMemberRequest request, @MappingTarget Member member);

}
