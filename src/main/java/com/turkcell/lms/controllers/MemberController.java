package com.turkcell.lms.controllers;
import com.turkcell.lms.services.dtos.requests.member.AddMemberRequest;
import com.turkcell.lms.services.dtos.requests.member.UpdateMemberRequest;
import com.turkcell.lms.services.dtos.responses.member.AddMemberResponse;
import com.turkcell.lms.services.dtos.responses.member.GetByIdMemberResponse;
import com.turkcell.lms.services.dtos.responses.member.UpdateMemberResponse;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.services.dtos.responses.member.ListMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members/")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;

    @GetMapping()
    public List<ListMemberResponse> getAll(){
        return memberService.getAll();
    }

    @GetMapping("{id}")
    public Optional<GetByIdMemberResponse> getMemberById(@PathVariable int id){
        return memberService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteMemberById(@PathVariable int id){
        memberService.deleteMemberById(id);
    }

    @PostMapping
    public ResponseEntity<AddMemberResponse> add(@RequestBody AddMemberRequest request)
    {
        AddMemberResponse response = memberService.addMember(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("{id}")
    public UpdateMemberResponse updateMember(@PathVariable int id, @RequestBody UpdateMemberRequest request){
        return memberService.updateMember(id, request);
    }

}