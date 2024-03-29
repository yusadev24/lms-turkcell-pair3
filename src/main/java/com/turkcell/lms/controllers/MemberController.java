package com.turkcell.lms.controllers;
import com.turkcell.lms.entities.Member;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.services.responses.GetAllMembersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members/")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;

    @GetMapping("/getall")
    public List<GetAllMembersResponse> getAll(){
        return memberService.getAll();
    }

    @GetMapping
    public String get(@RequestParam String name)
    {
        return "Merhaba " + name;
    }

    @GetMapping("{id}")
    public Optional<Member> getMemberById(@PathVariable int id){
        return memberService.getById(id);
    }

    @PostMapping
    public Member addMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

}
