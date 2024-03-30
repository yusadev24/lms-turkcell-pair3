package com.turkcell.lms.services.concretes;

import com.turkcell.lms.dtos.requests.member.AddMemberRequest;
import com.turkcell.lms.dtos.requests.member.UpdateMemberRequest;
import com.turkcell.lms.dtos.responses.member.AddMemberResponse;
import com.turkcell.lms.dtos.responses.member.GetByIdMemberResponse;
import com.turkcell.lms.dtos.responses.member.UpdateMemberResponse;
import com.turkcell.lms.entities.Member;
import com.turkcell.lms.repositories.MemberRepository;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.dtos.responses.member.ListMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public List<ListMemberResponse> getAll(){

        List<Member> members = memberRepository.findAll();
        List<ListMemberResponse> membersResponses = new ArrayList<ListMemberResponse>();

        for (Member member : members){
            ListMemberResponse responseItem = new ListMemberResponse();
            responseItem.setId(member.getId());
            responseItem.setName(member.getName());
            responseItem.setSurname(member.getSurname());
            responseItem.setEmail(member.getEmail());
            responseItem.setPassword(member.getPassword());

            membersResponses.add(responseItem);
        }

        return membersResponses;
    }

    public Optional<GetByIdMemberResponse> getById(int id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        return memberOptional.map(member -> {
            GetByIdMemberResponse response = new GetByIdMemberResponse();
            response.setId(member.getId());
            response.setName(member.getName());
            response.setSurname(member.getSurname());
            response.setEmail(member.getEmail());
            response.setPassword(member.getPassword());
            return response;
        });
    }
    /*
    * public Optional<GetByIdMemberResponse> getById(int id) {
    Optional<Member> memberOptional = memberRepository.findById(id);

    if (memberOptional.isPresent()) {
        Member member = memberOptional.get();

        GetByIdMemberResponse response = new GetByIdMemberResponse();
        response.setId(member.getId());
        response.setName(member.getName());
        response.setSurname(member.getSurname());
        response.setEmail(member.getEmail());
        response.setPassword(member.getPassword());

        return Optional.of(response);
    } else {
        return Optional.empty();
    }
}
    * */
    public void deleteMemberById(int id){
        if (!memberRepository.existsById(id)) {
            throw new IllegalArgumentException("Member with ID " + id + " does not exist");
        }
        memberRepository.deleteById(id);
    }

    @Override
    public AddMemberResponse addMember(AddMemberRequest request) {

        if(request.getName().length() < 3)
            throw new RuntimeException("Member ismi en az 3 hane olmalıdır.");
        Member member = new Member();
        member.setName(request.getName());
        member.setSurname(request.getSurname());
        member.setEmail(request.getEmail());
        member.setPassword(request.getPassword());
        member.setMemberNumber(request.getMemberNumber());
        Member savedMember= memberRepository.save(member);
        AddMemberResponse response= new AddMemberResponse(savedMember.getId(),
                savedMember.getName(),
                savedMember.getSurname(),
                savedMember.getEmail(),
                savedMember.getPassword()
                );

        return response;
    }

    public UpdateMemberResponse updateMember(int id, UpdateMemberRequest request) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        UpdateMemberResponse response = new UpdateMemberResponse();

        memberOptional.ifPresent(member -> {
            member.setEmail(request.getEmail());
            member.setPassword(request.getPassword());
            memberRepository.save(member);

            response.setId(member.getId());
            response.setName(member.getName());
            response.setSurname(member.getSurname());
            response.setPassword(member.getPassword());
            response.setEmail(member.getEmail());
        });

        return response;
    }

}