package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Member;
import com.turkcell.lms.repositories.MemberRepository;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.services.responses.GetAllMembersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
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

    public Optional<Member> getById(int id){

        return null;
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

}