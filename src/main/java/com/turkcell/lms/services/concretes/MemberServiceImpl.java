package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Member;
import com.turkcell.lms.repositories.MemberRepository;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.services.responses.GetAllMembersResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    public List<GetAllMembersResponse> getAll(){

        List<Member> members = memberRepository.findAll();
        List<GetAllMembersResponse> membersResponses = new ArrayList<GetAllMembersResponse>();

        for (Member member : members){
            GetAllMembersResponse responseItem = new GetAllMembersResponse();
            responseItem.setId(member.getId());
            responseItem.setName(member.getName());
            responseItem.setSurname(member.getSurname());

            membersResponses.add(responseItem);
        }

        return membersResponses;
    }
}