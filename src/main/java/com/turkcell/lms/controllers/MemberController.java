package com.turkcell.lms.controllers;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.services.responses.GetAllMembersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
