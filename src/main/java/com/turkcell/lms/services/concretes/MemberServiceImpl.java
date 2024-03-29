package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Member;
import com.turkcell.lms.repositories.MemberRepository;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.services.responses.GetAllMembersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

        return memberRepository.findById(id);
    }

    public void deleteMemberById(int id){
        if (!memberRepository.existsById(id)) {
            throw new IllegalArgumentException("Member with ID " + id + " does not exist");
        }
        memberRepository.deleteById(id);
    }

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

}